package quick.pager.shop.model.goods;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class Goods extends Model {

    private static final long serialVersionUID = 4792746346655301002L;
    // 商品分类Id
    private Long gcsId;
    // 商户Id
    private Long sellerId;

    private String goodsName;

    private String goodsCode;

    private Integer goodsStatus;

    private Integer goodsType;

    private BigDecimal goodsAmount;

    private BigDecimal goodsDiscountAmount;

    private Integer integral;

    private Integer goodsInventory;
    // 模型对应，无数据库映射
    private boolean join;

}
