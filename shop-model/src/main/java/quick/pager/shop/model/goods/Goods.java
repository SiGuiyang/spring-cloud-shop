package quick.pager.shop.model.goods;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 商品表
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Goods extends Model {

    private static final long serialVersionUID = -1311180545238502436L;

    private String goodsName;

    private BigDecimal goodsAmount;
}
