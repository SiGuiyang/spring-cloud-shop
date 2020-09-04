package quick.pager.shop.param.exchange;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityPageParam extends PageParam {
    private static final long serialVersionUID = -256563756822376249L;
    /**
     * 活动名称
     */
    private String activityName;
}
