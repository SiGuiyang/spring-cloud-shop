package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;


/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class InviteCodeDTO extends ManageDTO {
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
