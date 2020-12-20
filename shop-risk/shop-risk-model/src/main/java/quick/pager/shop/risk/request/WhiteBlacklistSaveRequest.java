package quick.pager.shop.risk.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 白/黑名单
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WhiteBlacklistSaveRequest extends Request {
    private static final long serialVersionUID = -5149141750846895095L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 禁用 true ，启用 false
     */
    private Boolean state;
}
