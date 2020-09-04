package quick.pager.shop.activity.response.assemble;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 拼团成员
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleMemberResponse extends BasicResponse {
    private static final long serialVersionUID = 2129843004649697765L;

    private Long id;

    private Long activityId;

    private Long recordId;

    private String phone;

    private String username;

    private Boolean master;

    private int status;

    private LocalDateTime groupTime;
}
