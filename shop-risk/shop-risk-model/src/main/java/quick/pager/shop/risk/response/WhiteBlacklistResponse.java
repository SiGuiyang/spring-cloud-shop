package quick.pager.shop.risk.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 白/黑名单
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WhiteBlacklistResponse extends BasicResponse {
    private static final long serialVersionUID = 5519745459965633791L;
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
