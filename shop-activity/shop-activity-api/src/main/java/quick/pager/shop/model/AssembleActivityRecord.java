package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_assemble_activity_record")
public class AssembleActivityRecord extends Model {

    private static final long serialVersionUID = -626383581837906008L;

    private Long activityId;

    private Integer status;
}
