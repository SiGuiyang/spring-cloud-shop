package quick.pager.shop.user.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ForgetPasswordDTO extends DTO {
    private static final long serialVersionUID = -43319194565812207L;

    /**
     * 手机号码
     */
    private String phone;
}
