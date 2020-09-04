package quick.pager.shop.goods.request.brand;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 商品品牌保存
 * request
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandSaveRequest extends Request {

    private static final long serialVersionUID = 2456020424577063678L;
    /**
     * t_goods_brand_group 主键
     */
    private Long brandGroupId;
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
