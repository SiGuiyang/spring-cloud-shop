package quick.pager.shop.manage.param.exchange;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * 满赠换购
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityPageParam extends PageParam {
    private static final long serialVersionUID = -7698770422003996732L;

    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 查询的时间范围
     */
    private List<LocalDateTime> timeRange;
}
