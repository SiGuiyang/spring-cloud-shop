package quick.pager.shop.response;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleMemberResponse extends BasicResponse {
    private static final long serialVersionUID = 2129843004649697765L;

    private Long activityId;

    private Long recordId;

    private String activityName;

    private String phone;

    private String username;

    private Boolean master;

    private int status;

    private Date groupTime;
}
