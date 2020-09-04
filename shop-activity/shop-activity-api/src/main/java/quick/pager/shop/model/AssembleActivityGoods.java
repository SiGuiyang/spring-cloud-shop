package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_assemble_activity_goods")
public class AssembleActivityGoods extends Model {

    private static final long serialVersionUID = 8176754461106350259L;

    private Long goodsId;

    private Long activityId;

    private Long ruleId;

}
