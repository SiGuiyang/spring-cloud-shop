package quick.pager.shop.order.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_seller_order")
public class SellerOrder extends Model {

    private static final long serialVersionUID = 5577928979748151630L;
    private Long sellerId;

    private Long userOrderId;

    private BigDecimal orderAmount;

    private String orderCode;

    private Integer orderStatus;

}
