package quick.pager.shop.activity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_assemble_activity_record")
public class AssembleActivityRecord extends Model {

    private static final long serialVersionUID = -626383581837906008L;

    private Long activityId;

    private Integer status;
}
