package quick.pager.shop.risk.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 黑名单SaveRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlackListSaveRequest extends Request {
    private static final long serialVersionUID = 1796011177745256362L;
}
