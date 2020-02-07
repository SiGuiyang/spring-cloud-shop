package quick.pager.shop.param;

import java.io.Serializable;
import lombok.Data;

@Data
public class SendParam implements Serializable {

    private static final long serialVersionUID = -813996511957130L;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 发送短信事件源
     */
    private String source;
    /**
     * 图形验证码
     */
    private String graphicCode;
    /**
     * 短信内容
     */
    private String content;
}
