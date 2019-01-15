package quick.pager.shop.order.dto;

import lombok.Data;
import quick.pager.common.dto.DTO;

@Data
public class OrderDTO extends DTO {
    private static final long serialVersionUID = -2565429601495542035L;

    private Long userId;
    /**
     * 所有订单 1, 待付款 2, 待收货 3, 待自提 4, 待评价 5
     */
    private String order;
}
