package quick.pager.shop.dto.goods;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.BaseDTO;

/**
 * 商品品牌组 DTO
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandGroupDTO extends BaseDTO {
    private static final long serialVersionUID = 2876688941293791185L;

    /**
     * t_goods_brand_group 主键
     */
    private Long brandGroupId;
    /**
     * 品牌组名称
     */
    private String brandGroupName;
    /**
     * 序号
     */
    private Integer sequence;
}
