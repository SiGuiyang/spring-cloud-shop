package quick.pager.shop.param.exchange;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivitySaveParam extends Param {
    private static final long serialVersionUID = 2527948465056856168L;

    private Long id;
    /**
     * 时间范围
     */
    private List<LocalDateTime> dateTimes;
}
