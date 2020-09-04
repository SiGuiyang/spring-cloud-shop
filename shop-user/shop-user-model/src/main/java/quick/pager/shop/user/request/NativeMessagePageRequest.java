package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 站内信
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NativeMessagePageRequest extends PageRequest {
    private static final long serialVersionUID = -1376351904746695505L;
}
