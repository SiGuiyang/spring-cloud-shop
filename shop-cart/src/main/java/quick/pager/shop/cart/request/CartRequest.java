package quick.pager.shop.cart.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 购物车请求对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CartRequest extends Request {
    private static final long serialVersionUID = 4210136695507304701L;
}
