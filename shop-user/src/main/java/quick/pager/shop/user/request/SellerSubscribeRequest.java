package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 商户注册请求类
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SellerSubscribeRequest extends Request {
    private static final long serialVersionUID = 404899592198479729L;
}
