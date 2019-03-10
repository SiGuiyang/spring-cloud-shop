package quick.pager.shop.activity.service.client;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import java.io.DataInputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.common.service.RedisService;
import quick.pager.common.utils.FileUtil;
import quick.pager.shop.activity.mapper.DiscountCouponMapper;
import quick.pager.shop.activity.mapper.DiscountCouponTemplateMapper;
import quick.pager.shop.activity.task.SendCouponTask;
import quick.pager.shop.feign.client.UserClient;
import quick.pager.shop.feign.dto.PublishCouponDTO;
import quick.pager.shop.feign.dto.UserInfoDTO;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.model.activity.DiscountCouponTemplate;

/**
 * 发送优惠券
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class PublishCouponClientService implements IService {

    @Autowired
    private DiscountCouponTemplateMapper discountCouponTemplateMapper;
    @Autowired
    private DiscountCouponMapper discountCouponMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserClient userClient;


    @Override
    public Response doService(BaseDTO dto) {

        PublishCouponDTO publishCouponDTO = (PublishCouponDTO) dto;

        Response response = checkCouponTemplate(publishCouponDTO.getTemplateId());

        // 选择的优惠券模板可用
        if (ResponseStatus.Code.SUCCESS == response.getCode()) {
            log.info("选择的优惠券模板可用 templateId = {}", publishCouponDTO.getTemplateId());
            DiscountCouponTemplate template = (DiscountCouponTemplate) response.getData();
            DataInputStream inputStream = null;

            try {

                inputStream = FileUtil.getRemoteFile(publishCouponDTO.getFile());
                // 初始设置补发优惠券的大小
                List<String> phones = Lists.newArrayList();
                Excel07SaxReader reader = new Excel07SaxReader((sheetIndex, rowIndex, rowList) -> {
                    // 过滤掉标题
                    if (0 != rowIndex) {
                        phones.add(rowList.get(0).toString());
                    }
                });

                reader.read(inputStream, 0);

                if (CollectionUtils.isEmpty(phones)) {
                    response.setCode(ResponseStatus.Code.FAIL_CODE);
                    response.setMsg(ResponseStatus.PUBLISH_COUPON_PHONE_IS_BLANK);
                    return response;
                }
                String[] phonesParam = new String[phones.size()];
                // 取出正常的用户
                Response<List<UserInfoDTO>> existsResponse = userClient.isExists(phones.toArray(phonesParam));

                List<UserInfoDTO> exists = null;
                if (null != existsResponse.getData()) {
                    exists = existsResponse.getData();
                }


                // 正常用户的手机号
                List<String> normalPhones = Lists.newArrayList();

                List<DiscountCoupon> discountCoupons = Lists.newArrayList();

                if (!CollectionUtils.isEmpty(exists)) {
                    // 当前补发优惠券的人数大于1000，则采用线程方式发送
                    if (exists.size() >= 1000) {
                        // 多线程执行后返回正常的插入的手机号
                        List<String> list = new ForkJoinPool(2).invoke(new SendCouponTask(exists, template, discountCouponMapper));

                        phones.removeAll(list);

                    } else {

                        exists.forEach(v -> {

                            normalPhones.add(v.getPhone());

                            DiscountCoupon discountCoupon = new DiscountCoupon();
                            discountCoupon.setCouponName(template.getTemplateName());
                            discountCoupon.setPhone(v.getPhone());
                            discountCoupon.setBeginTime(new Date());
                            discountCoupon.setEndTime(DateUtil.offsetDay(new Date(), 3));
                            discountCoupon.setCouponAmount(template.getCouponAmount());
                            discountCoupon.setOrderAmount(template.getOrderAmount());
                            discountCoupon.setDiscountType(template.getTemplateType());
                            discountCoupon.setDiscountStrength(template.getDiscountStrength());
                            discountCoupon.setUserId(v.getId());
                            discountCoupon.setCreateTime(new Date());
                            discountCoupon.setDeleteStatus(false);
                            discountCoupon.setDescription(template.getDescription());
                            discountCoupon.setTemplateId(template.getId());

                            discountCoupons.add(discountCoupon);

                        });

                        discountCouponMapper.batchInsertSelective(discountCoupons);

                    }

                    // 取出非正常的手机号
                    phones.removeAll(normalPhones);

                    // 最后得到的phones 存在的值必然是错误用户的手机号,这里的错误信息只提供参考，不打算存储在数据库中，放入redis中时效性1个月
                    if (!CollectionUtils.isEmpty(phones)) {
                        redisService.set(RedisKeys.ManageKeys.SEND_COUPON_LIST + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN), JSON.toJSONString(phones), 30 * 60 * 60 * 24);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IoUtil.close(inputStream);
            }
        }

        return response;
    }


    /**
     * 检验优惠券模板的实效性
     *
     * @param templateId 模板Id
     */
    private Response<DiscountCouponTemplate> checkCouponTemplate(Long templateId) {
        Response<DiscountCouponTemplate> response = new Response<>();
        DiscountCouponTemplate template = discountCouponTemplateMapper.selectByPrimaryKey(templateId);
        if (ObjectUtils.isEmpty(template)) {
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg("优惠券模板不存在");
            return response;
        }

        if (template.getDeleteStatus()) {
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg("优惠券模板已禁用");
            return response;
        }
        response.setData(template);
        return response;
    }

}
