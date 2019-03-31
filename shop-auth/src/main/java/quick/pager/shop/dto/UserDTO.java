package quick.pager.shop.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 3462481232090532831L;
    private Long id;

    // 登陆用户名
    private String username;

    // 密码
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
