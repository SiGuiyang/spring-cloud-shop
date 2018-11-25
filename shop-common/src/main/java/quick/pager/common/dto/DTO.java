package quick.pager.common.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class DTO implements Serializable {
    private static final long serialVersionUID = -1027750679708024114L;

    private Long id;

}
