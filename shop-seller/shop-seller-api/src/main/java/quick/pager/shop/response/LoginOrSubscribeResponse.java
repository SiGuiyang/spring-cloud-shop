package quick.pager.shop.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 登陆返回数据渲染
 *
 * @author siguiyang
 */
@Data
public class LoginOrSubscribeResponse implements Serializable {
    private static final long serialVersionUID = -521432465210624041L;

    private Long userId;

    private String username;

    private String phone;

    private String avatar;

    private String token;

}
