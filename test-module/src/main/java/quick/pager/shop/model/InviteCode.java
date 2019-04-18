package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class InviteCode extends Model {
    /**
     * 用户Id
     */
    private Long userId;
    private Long templateId;
    private String code;
    private java.util.Date createTime;
    private java.util.Date updateTime;
    private String createUser;
    private Boolean deleteStatus;
}
