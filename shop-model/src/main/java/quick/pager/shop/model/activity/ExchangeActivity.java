package quick.pager.shop.model.activity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_exchange_activity")
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

    private Date beginTime;

    private Date endTime;

}
