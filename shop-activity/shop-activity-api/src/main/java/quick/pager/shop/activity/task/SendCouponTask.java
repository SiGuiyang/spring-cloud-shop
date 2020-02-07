package quick.pager.shop.activity.task;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import quick.pager.shop.activity.mapper.DiscountCouponMapper;
import quick.pager.shop.activity.model.DiscountCoupon;
import quick.pager.shop.activity.model.DiscountCouponTemplate;
import quick.pager.shop.user.response.UserInfoResponse;
import quick.pager.shop.utils.DateUtils;

/**
 * 发送优惠券线程
 *
 * @author siguiyang
 */
@Slf4j
public class SendCouponTask extends RecursiveTask<List<String>> {
    private static final long serialVersionUID = 3590505263802424175L;

    private List<UserInfoResponse> users;

    private DiscountCouponTemplate discountCouponTemplate;

    private DiscountCouponMapper discountCouponMapper;

    /**
     * 容量值
     */
    private static final int CAPACITY = 1000;

    public SendCouponTask(List<UserInfoResponse> users, DiscountCouponTemplate discountCouponTemplate, DiscountCouponMapper discountCouponMapper) {
        this.users = users;
        this.discountCouponTemplate = discountCouponTemplate;
        this.discountCouponMapper = discountCouponMapper;
    }

    @Override
    protected List<String> compute() {

        if (users.isEmpty()) {
            return Lists.newArrayList();
        }

        if (users.size() <= CAPACITY) {

            users.forEach(item -> {
                DiscountCoupon discountCoupon = new DiscountCoupon();
                discountCoupon.setUserId(item.getId());
                discountCoupon.setTemplateId(discountCouponTemplate.getId());
                discountCoupon.setUsed(Boolean.FALSE);
                discountCoupon.setCreateTime(DateUtils.dateTime());
                discountCoupon.setDeleteStatus(Boolean.FALSE);
                discountCouponMapper.insert(discountCoupon);
            });

            return users.stream().map(UserInfoResponse::getPhone).collect(Collectors.toList());
        }


        int middle = users.size() / 2;
        List<UserInfoResponse> one = Lists.newArrayList();
        List<UserInfoResponse> two = Lists.newArrayList();

        for (int i = 0; i < users.size(); i++) {
            if (i < middle) {
                one.add(users.get(i));
            } else {
                two.add(users.get(i));
            }
        }

        SendCouponTask task1 = new SendCouponTask(one, discountCouponTemplate, discountCouponMapper);
        SendCouponTask task2 = new SendCouponTask(two, discountCouponTemplate, discountCouponMapper);
        invokeAll(task1, task2);

        List<String> result = Lists.newArrayList();
        result.addAll(task1.join());
        result.addAll(task2.join());

        return result;
    }
}
