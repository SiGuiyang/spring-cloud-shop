package quick.pager.shop.goods.request.brand;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 商品品牌组保存
 * request
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandGroupSaveRequest extends Request {
    private static final long serialVersionUID = 5927681281149773666L;

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
