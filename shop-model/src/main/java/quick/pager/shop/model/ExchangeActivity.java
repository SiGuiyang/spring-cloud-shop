package quick.pager.shop.model;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivity extends Model {
    private static final long serialVersionUID = 5899171576409045835L;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动图片
     */
    private String activityImg;
    /**
     * 更新操作人
     */
    private String updateUser;

    private Date beginTime;

    private Date endTime;

}
