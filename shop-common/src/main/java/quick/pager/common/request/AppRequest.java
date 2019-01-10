package quick.pager.common.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AppRequest extends Request {
    private static final long serialVersionUID = -1693038442756414800L;

    /**
     * 用户token
     */
    private String token;
}
