package quick.pager.shop.user.request;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 站内信
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AppNativeMessageRequest extends Request {
    private static final long serialVersionUID = 473556005516138206L;

    private Long userId;

    private List<Long> messageIds;
}
