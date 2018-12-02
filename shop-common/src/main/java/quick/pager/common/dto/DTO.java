package quick.pager.common.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
public class DTO implements Serializable {
    private static final long serialVersionUID = -1027750679708024114L;

    private Long id;

    public DTO() {
    }

    public DTO(Long id) {
        this.id = id;
    }
}
