package quick.pager.shop.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.BaseDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class StationMessageDTO extends BaseDTO {
    private static final long serialVersionUID = 473556005516138206L;

    private Long userId;

    private List<Long> messageId;
}
