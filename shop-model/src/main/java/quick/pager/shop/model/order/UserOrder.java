package quick.pager.shop.model.order;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserOrder extends Model {

    private static final long serialVersionUID = -4697773373352516686L;
    private Long userId;

    private Long goodsId;

    private Long sellerId;

    private Long shipId;

    private String orderCode;

    private String orderStatus;

    private Integer orderType;

    private BigDecimal orderAmount;

    private Integer integral;

    private BigDecimal integralAmount;

    private Integer goodsCount;

    private Boolean self;

}