package quick.pager.shop.manage.param.assemble;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * 拼团
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssemblePageParam extends PageParam {
    private static final long serialVersionUID = 6946046825412042860L;

    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 查询的时间范围
     */
    private List<LocalDateTime> timeRange;
}
