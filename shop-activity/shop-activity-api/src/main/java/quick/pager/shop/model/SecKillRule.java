package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 秒杀规则
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("t_sec_kill_rule")
public class SecKillRule extends Model {
    private static final long serialVersionUID = -7652908619807230502L;


}
