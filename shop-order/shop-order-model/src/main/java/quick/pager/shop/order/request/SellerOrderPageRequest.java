package quick.pager.shop.order.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class SellerOrderPageRequest extends PageRequest {
    private static final long serialVersionUID = 2370158929485767003L;
}
