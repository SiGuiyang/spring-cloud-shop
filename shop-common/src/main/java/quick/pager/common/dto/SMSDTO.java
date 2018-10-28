package quick.pager.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 短信公共服务数据对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SMSDTO extends DTO {
    private static final long serialVersionUID = 6004420887746924633L;

    private String phone;

    private String content;

}
