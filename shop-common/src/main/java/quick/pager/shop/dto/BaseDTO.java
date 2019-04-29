package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BaseDTO extends DTO {

    private static final long serialVersionUID = -2303123669547996281L;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 分页数大小
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer page;
    /**
     * 手机号
     */
    private String phone;
}
