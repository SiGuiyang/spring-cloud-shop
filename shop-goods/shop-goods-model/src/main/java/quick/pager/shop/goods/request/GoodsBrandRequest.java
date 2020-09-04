package quick.pager.shop.goods.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 商品品牌
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandRequest extends Request {
    private static final long serialVersionUID = -3743595911609483852L;

    /**
     * t_goods_brand_group id 主键
     */
    private Long brandGroupId;
    /**
     * 品牌组名称
     */
    private String brandGroupName;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌编码
     */
    private String brandCode;

    /**
     * 品牌图标
     */
    private String icon;

    /**
     * 序号
     */
    private Integer sequence;
}
