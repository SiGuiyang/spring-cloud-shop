package quick.pager.shop.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AppRequest extends PageRequest {
    private static final long serialVersionUID = -1693038442756414800L;

    private Long userId;
    /**
     * 用户token
     */
    private String token;
}
