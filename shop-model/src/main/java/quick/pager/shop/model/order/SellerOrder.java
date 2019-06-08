package quick.pager.shop.model.order;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class SellerOrder extends Model {

    private static final long serialVersionUID = 5577928979748151630L;
    private Long sellerId;

    private Long userOrderId;

    private BigDecimal orderAmount;

    private String orderCode;

    private Integer orderStatus;

}
