package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 拼团规则
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_assemble_activity_rule")
public class AssembleActivityRule extends Model {
    private static final long serialVersionUID = 827954724434418257L;

    /**
     * 活动主键
     */
    private Long activityId;
    /**
     * 状态
     */
    private Boolean serverStatus;
    /**
     * 限购次数
     */
    private Integer purchaseLimit;
    /**
     * 成团人数
     */
    private Integer assembleCount;
    /**
     * 说明
     */
    private String description;

}
