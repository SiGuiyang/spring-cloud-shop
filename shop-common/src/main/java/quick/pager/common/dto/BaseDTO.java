package quick.pager.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BaseDTO extends DTO {

    private static final long serialVersionUID = -2303123669547996281L;

    private Integer pageSize;

    private Integer page;

    /**
     * 手机号
     */
    private String phone;
}
