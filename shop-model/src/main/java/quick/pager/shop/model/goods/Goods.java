package quick.pager.shop.model.goods;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class Goods extends Model {

    private static final long serialVersionUID = 4792746346655301002L;

    private Long gcsId;

    private String goodsName;

    private String goodsCode;

    private Integer goodsStatus;

    private Integer goodsType;

    private BigDecimal goodsAmount;

    private BigDecimal goodsDiscountAmount;

    private String description;

    private Integer integral;

    private Integer goodsInventory;

}