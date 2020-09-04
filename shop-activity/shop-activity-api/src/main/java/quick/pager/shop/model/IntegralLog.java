package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_integral_log")
public class IntegralLog extends Model {
    private static final long serialVersionUID = -8874907953710748883L;

    private Long userId;

    private Long integral;

    private String description;

}
