package quick.pager.shop.model.feign.response;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class FightGroupResponse implements Serializable {

    private static final long serialVersionUID = -6680509618756357001L;

    private Long id;

    private Long ruleId;

    private Long goodsId;

    private String activityName;

    private String activityImg;

    private Date beginTime;

    private Date endTime;

    private Date createTime;

    private String createUser;

}
