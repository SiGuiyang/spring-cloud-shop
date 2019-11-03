package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.dto.activity.CouponDTO;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.response.Response;

/**
 * 优惠券服务
 *
 * @author siguiyang
 */
public interface DiscountCouponService extends IPageService<DiscountCoupon> {

    /**
     * 优惠券列表
     */
    Response<List<DiscountCoupon>> list(CouponDTO dto);

    /**
     * 获取一张优惠券详情
     */
    Response<DiscountCoupon> info(Long id);

    /**
     * 发送优惠券
     *
     * @param file       远程文件地址
     * @param templateId 优惠券模版主键
     */
    Response publish(String file, Long templateId);

}
