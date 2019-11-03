package quick.pager.shop.model.activity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
@TableName("t_assemble_activity")
public class AssembleActivity extends Model {

    private static final long serialVersionUID = 8816387730047149630L;

    private String activityName;

    private String activityImg;

    private Date beginTime;

    private Date endTime;

}
