package quick.pager.shop.risk.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 白/黑名单pageRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WhiteBlacklistPageRequest extends PageRequest {

    private static final long serialVersionUID = 6886372019151543394L;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 禁用 true ，启用 false
     */
    private Boolean state;
    /**
     * 时间范围
     */
    private List<LocalDateTime> range;

}
