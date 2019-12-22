package quick.pager.shop.activity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_assemble_activity_rule")
public class AssembleActivityRule extends Model {
    private static final long serialVersionUID = 827954724434418257L;

    private Long activityId;

    private Integer purchaseLimit;

    private Integer assembleCount;

    private String description;

}
