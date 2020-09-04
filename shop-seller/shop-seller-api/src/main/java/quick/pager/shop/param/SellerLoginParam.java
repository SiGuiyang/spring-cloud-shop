package quick.pager.shop.param;

import java.io.Serializable;
import lombok.Data;

/**
 * 登陆
 */
@Data
public class SellerLoginParam implements Serializable {
    private static final long serialVersionUID = -8483169592580367377L;

    /**
     * 登陆密码
     */
    private String password;

}
