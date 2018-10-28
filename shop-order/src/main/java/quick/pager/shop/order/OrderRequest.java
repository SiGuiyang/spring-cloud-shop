package quick.pager.shop.order;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 订单请求对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderRequest extends Request {
    private static final long serialVersionUID = -4293642433801173832L;
}
