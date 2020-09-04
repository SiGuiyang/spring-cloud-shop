package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_assemble_activity_member")
public class AssembleActivityMember extends Model {
    private static final long serialVersionUID = -2987561966562272975L;

    private Long activityId;

    private Long recordId;

    private Long userId;

    private String phone;

    private String username;

    private Boolean master;

}
