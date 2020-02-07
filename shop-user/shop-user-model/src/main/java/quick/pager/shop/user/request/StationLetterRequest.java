package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.PageRequest;

/**
 * 站内信
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StationLetterRequest extends PageRequest {
    private static final long serialVersionUID = -1376351904746695505L;
}
