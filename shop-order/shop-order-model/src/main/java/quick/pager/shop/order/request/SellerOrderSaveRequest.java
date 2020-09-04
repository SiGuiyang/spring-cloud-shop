package quick.pager.shop.order.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class SellerOrderSaveRequest extends Request {
    private static final long serialVersionUID = 2370158929485767003L;
}
