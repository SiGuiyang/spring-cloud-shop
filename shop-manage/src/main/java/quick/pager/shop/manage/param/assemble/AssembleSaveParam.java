package quick.pager.shop.manage.param.assemble;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 拼团保存
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleSaveParam extends Param {

    private static final long serialVersionUID = -1199981398319587818L;

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
