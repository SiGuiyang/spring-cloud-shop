package quick.pager.shop.activity.response;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class FightGroupRecordResponse implements Serializable {
    private static final long serialVersionUID = 5019774132283623079L;

    private Long id;

    private Long groupId;

    private Integer status;

    private String activityName;

    private Date createTime;
}
