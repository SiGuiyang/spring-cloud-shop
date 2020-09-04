package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
@TableName("t_assemble_activity")
public class AssembleActivity extends Model {

    private static final long serialVersionUID = 8816387730047149630L;

    private String activityName;

    private String activityImg;

    private Boolean serverStatus;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

}
