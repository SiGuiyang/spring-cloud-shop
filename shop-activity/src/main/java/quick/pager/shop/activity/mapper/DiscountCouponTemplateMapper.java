package quick.pager.shop.activity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.DiscountCouponTemplate;

public interface DiscountCouponTemplateMapper {

    int insertSelective(DiscountCouponTemplate record);

    DiscountCouponTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DiscountCouponTemplate record);

    /**
     * 查询优惠券模板
     *
     * @param templateName 模板名称
     * @param templateType 模板类型
     */
    List<DiscountCouponTemplate> selectTemplates(@Param("templateName") String templateName, @Param("templateType") Integer templateType);
}