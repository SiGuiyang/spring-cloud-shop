package quick.pager.shop.feign.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.ManageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class SellerOrderRequest extends ManageRequest {
    private static final long serialVersionUID = 2370158929485767003L;
}
