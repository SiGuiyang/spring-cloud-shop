package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单评价
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_order_evaluate")
public class OrderEvaluate extends Model {

    private static final long serialVersionUID = 9104021175949931054L;
    private Long id;

    private Long userId;

    private String content;
}
