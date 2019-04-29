package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserOrderDTO extends AppDTO {
    private static final long serialVersionUID = -5822489513088258957L;

    /**
     * 订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单
     */
    private Integer orderType;

}
