package quick.pager.shop.model.order;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_user_order")
public class UserOrder extends Model {

    private static final long serialVersionUID = -4697773373352516686L;
    private Long userId;

    private Long buyOrderCartId;

    private Long sellerId;

    private Long shipId;

    private Long couponId;

    private String phone;

    private String orderCode;

    private String orderStatus;

    private Integer orderType;

    private BigDecimal orderAmount;

    private Integer integral;

    private BigDecimal integralAmount;

    private BigDecimal discountAmount;

    private Boolean self;

}
