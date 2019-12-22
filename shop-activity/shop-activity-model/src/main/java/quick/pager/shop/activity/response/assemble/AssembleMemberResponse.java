package quick.pager.shop.activity.response.assemble;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.response.BasicResponse;

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
