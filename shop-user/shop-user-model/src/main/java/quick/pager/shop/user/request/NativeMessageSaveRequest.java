package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.enums.NativeMessageStatusEnums;

/**
 * 站内信
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class NativeMessageSaveRequest extends Request {
    private static final long serialVersionUID = 597149817817229930L;

    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 当前登陆人手机号码
     */
    private String phone;
    /**
     * 站内信内容
     */
    private String content;
    /**
     * 站内信状态
     */
    private NativeMessageStatusEnums status;
}
