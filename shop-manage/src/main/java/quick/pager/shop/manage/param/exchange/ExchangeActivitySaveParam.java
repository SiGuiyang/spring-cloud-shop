package quick.pager.shop.manage.param.exchange;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 满赠换购
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivitySaveParam extends Param {

    private static final long serialVersionUID = -5307259513896084446L;
    private Long id;
    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动图片
     */
    private String activityImg;

    /**
     * 周期
     */
    private List<LocalDateTime> timeRange;
}
