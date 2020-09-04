package quick.pager.shop.param;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 站内信
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AppNativeMessageParam extends Param {
    private static final long serialVersionUID = 473556005516138206L;

    private Long userId;

    private List<Long> messageIds;
}
