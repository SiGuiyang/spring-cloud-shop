package quick.pager.shop.model.activity;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class FightGroup extends Model {

    private static final long serialVersionUID = 8816387730047149630L;
    private String activityName;

    private String activityImg;

    private Date beginTime;

    private Date endTime;

    private String createUser;

}