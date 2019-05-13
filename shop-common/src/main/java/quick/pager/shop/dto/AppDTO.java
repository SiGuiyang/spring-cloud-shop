package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AppDTO extends BaseDTO {
    private static final long serialVersionUID = -9060399563494029218L;
    /**
     * 用户token
     */
    private String token;

}
