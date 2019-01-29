package quick.pager.shop.order.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.AppDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDTO extends AppDTO {
    private static final long serialVersionUID = -2565429601495542035L;

    /**
     * 所有订单 1, 待付款 2, 待收货 3, 待自提 4, 待评价 5
     */
    private String order;
}
