package quick.pager.shop.task;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import lombok.extern.slf4j.Slf4j;
import quick.pager.shop.mapper.DiscountCouponMapper;
import quick.pager.shop.dto.user.UserInfoDTO;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.model.activity.DiscountCouponTemplate;
import quick.pager.shop.utils.DateUtils;

@Slf4j
public class SendCouponTask extends RecursiveTask<List<String>> {
    private static final long serialVersionUID = 3590505263802424175L;

    private List<UserInfoDTO> users;

    private DiscountCouponTemplate discountCouponTemplate;

    private DiscountCouponMapper discountCouponMapper;

    // 容量值
    private static final int CAPACITY = 1000;

    public SendCouponTask(List<UserInfoDTO> users, DiscountCouponTemplate discountCouponTemplate, DiscountCouponMapper discountCouponMapper) {
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

            List<DiscountCoupon> discountCoupons = Lists.newArrayList();
            List<String> normalPhones = Lists.newArrayList();

            users.forEach(v -> {
                DiscountCoupon discountCoupon = new DiscountCoupon();
                discountCoupon.setUserId(v.getId());
                discountCoupon.setTemplateId(discountCouponTemplate.getId());
                discountCoupon.setUsed(Boolean.FALSE);
                discountCoupon.setCreateTime(DateUtils.dateTime());
                discountCoupon.setUpdateTime(DateUtils.dateTime());
                discountCoupon.setDeleteStatus(Boolean.FALSE);

                discountCoupons.add(discountCoupon);

                normalPhones.add(v.getPhone());
            });

            discountCouponMapper.batchInsertSelective(discountCoupons);
            return normalPhones;

        }


        int middle = users.size() / 2;
        List<UserInfoDTO> one = Lists.newArrayList();
        List<UserInfoDTO> two = Lists.newArrayList();


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
