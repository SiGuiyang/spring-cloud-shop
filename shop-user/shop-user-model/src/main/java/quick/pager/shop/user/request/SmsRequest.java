package quick.pager.shop.user.request;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信发送请求对象
 *
 * @author siguiyang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmsRequest implements Serializable {
    private static final long serialVersionUID = 8828624204176689726L;

    /**
     * 手机号码
     */
    private String phone;
    /**
     * 发送短信事件源
     */
    private String source;
}
