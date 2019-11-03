package quick.pager.shop.dto.goods;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.BaseDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandDTO extends BaseDTO {
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
