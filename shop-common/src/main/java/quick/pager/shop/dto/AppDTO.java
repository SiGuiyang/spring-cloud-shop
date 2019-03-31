package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AppDTO extends BaseDTO {
    private static final long serialVersionUID = -9060399563494029218L;

    @NonNull
    private Long userId;
    /**
     * 用户token
     */
    private String token;

}
