package quick.pager.shop.service.activity;

import quick.pager.shop.dto.CouponTemplateDTO;
import quick.pager.shop.response.Response;

/**
 * 优惠券模板
 *
 * @author siguiyang
 */
public interface CouponTemplateService {

    /**
     * 优惠券模板列表
     */
    Response template(CouponTemplateDTO dto);

    /**
     * 修改优惠券模板
     */
    Response modifyTemplate(CouponTemplateDTO dto);

    /**
     * 优惠券模板新增
     */
    Response addTemplate(CouponTemplateDTO dto);
}
