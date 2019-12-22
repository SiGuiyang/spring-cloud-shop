package quick.pager.shop.activity.response;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class FightGroupMemberResponse implements Serializable{
    private static final long serialVersionUID = 1049531574585745121L;

    private Long id;

    private Long activityId;

    private Long recordId;

    private Integer openFightStatus;

    private String activityName;

    private String phone;

    private String username;

    private Boolean master;

    private Boolean deleteStatus;

    private Date createTime;

    private Date openGroupTime;

    private Date groupTime;
}
