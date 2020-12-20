package quick.pager.shop.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.support.MessageBuilder;
import quick.pager.shop.activity.constants.ActivityRedisKeys;
import quick.pager.shop.dto.PublishCouponDTO;
import quick.pager.shop.mapper.DiscountCouponMapper;
import quick.pager.shop.model.DiscountCoupon;
import quick.pager.shop.model.DiscountCouponTemplate;
import quick.pager.shop.mq.ActivityMQ;
import quick.pager.shop.user.client.UserClient;
import quick.pager.shop.user.enums.NativeMessageStatusEnums;
import quick.pager.shop.user.request.NativeMessageSaveRequest;
import quick.pager.shop.user.request.UserRequest;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserProfileResponse;
import quick.pager.shop.utils.DateUtils;

@Slf4j
public class PublishCouponDTOListener extends AnalysisEventListener<PublishCouponDTO> {

    private final DiscountCouponMapper discountCouponMapper;
    private final RedisTemplate<String, Object> redisTemplate;
    private final UserClient userClient;
    private final ActivityMQ activityMQ;
    private final DiscountCouponTemplate discountCouponTemplate;
    private List<PublishCouponDTO> result = Lists.newArrayList();
    /**
     * 批量操作数量
     */
    private static final int BATCH_COUNT = 20;

    public PublishCouponDTOListener(DiscountCouponMapper discountCouponMapper,
                                    RedisTemplate<String, Object> redisTemplate,
                                    UserClient userClient,
                                    ActivityMQ activityMQ,
                                    DiscountCouponTemplate discountCouponTemplate) {
        this.discountCouponMapper = discountCouponMapper;
        this.redisTemplate = redisTemplate;
        this.userClient = userClient;
        this.activityMQ = activityMQ;
        this.discountCouponTemplate = discountCouponTemplate;
    }

    @Override
    public void invoke(PublishCouponDTO data, AnalysisContext context) {
        result.add(data);

        if (result.size() >= BATCH_COUNT) {
            // 保存数据
            this.doProcess();
            // 清空数据
            result.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("补发优惠券Excel解析结束，优惠券模版名称 {}", discountCouponTemplate.getTemplateName());
        this.doProcess();
    }

    // 处理导入的文件
    private void doProcess() {

        List<String> phones = result.stream().map(PublishCouponDTO::getPhone).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(phones)) {
            UserRequest userReq = new UserRequest();
            userReq.setPhones(phones);
            Response<List<UserProfileResponse>> response = userClient.batchProfile(userReq);
            if (response.check()) {
                List<UserProfileResponse> responseData = response.getData();
                List<String> userPhones = Optional.ofNullable(responseData).orElse(Lists.newArrayList()).stream()
                        .map(UserProfileResponse::getPhone)
                        .collect(Collectors.toList());
                // 移除相同的手机号码，剩下的就是未匹配成功的用户
                phones.removeAll(userPhones);

                // 添加失败内容到redis
                if (CollectionUtils.isNotEmpty(phones)) {
                    String key = ActivityRedisKeys.COUPON_PUBLISH_FAILURE_PREFIX.concat(String.valueOf(discountCouponTemplate.getId()));
                    redisTemplate.opsForList().leftPushAll(key,
                            result.stream().filter(item -> phones.contains(item.getPhone())).collect(Collectors.toList()),
                            30 * 24 * 60 * 60L);
                }

                // 发送优惠券
                Optional.ofNullable(responseData).orElse(Lists.newArrayList())
                        .forEach(item -> {
                            DiscountCoupon coupon = new DiscountCoupon();
                            coupon.setTemplateId(discountCouponTemplate.getId());
                            coupon.setUsed(Boolean.FALSE);
                            coupon.setUserId(item.getId());
                            coupon.setPhone(item.getPhone());
                            coupon.setCreateUser("system");
                            coupon.setUpdateUser("system");
                            coupon.setCreateTime(DateUtils.dateTime());
                            coupon.setUpdateTime(DateUtils.dateTime());
                            coupon.setDeleteStatus(Boolean.FALSE);
                            discountCouponMapper.insert(coupon);
                            // 发送站内信
                            NativeMessageSaveRequest nativeMessageSaveReq = new NativeMessageSaveRequest();
                            nativeMessageSaveReq.setPhone(item.getPhone());
                            nativeMessageSaveReq.setUserId(item.getId());
                            nativeMessageSaveReq.setStatus(NativeMessageStatusEnums.NON_READ);
                            nativeMessageSaveReq.setContent("您收到一张补发优惠券，请在APP消息中查看");
                            activityMQ.sendStationMessage().send(MessageBuilder.withPayload(nativeMessageSaveReq).build());
                        });

            }
        }
    }
}
