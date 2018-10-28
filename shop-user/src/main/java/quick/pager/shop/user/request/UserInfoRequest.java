package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 用户信息请求对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoRequest extends Request {
    private static final long serialVersionUID = -7901600065995043251L;
}
