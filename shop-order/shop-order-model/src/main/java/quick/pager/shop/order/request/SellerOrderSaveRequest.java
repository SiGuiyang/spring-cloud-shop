package quick.pager.shop.order.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class SellerOrderSaveRequest extends ManageDTO {
    private static final long serialVersionUID = 2370158929485767003L;
}
