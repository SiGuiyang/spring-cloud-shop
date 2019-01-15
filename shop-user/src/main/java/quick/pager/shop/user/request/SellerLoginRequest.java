package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 商户登陆请求类
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SellerLoginRequest extends Request {
    private static final long serialVersionUID = 2252382530851383662L;
}
