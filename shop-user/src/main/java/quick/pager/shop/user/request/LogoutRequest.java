package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 退出登陆请求对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LogoutRequest extends Request {
    private static final long serialVersionUID = -6827856703162237881L;
}
