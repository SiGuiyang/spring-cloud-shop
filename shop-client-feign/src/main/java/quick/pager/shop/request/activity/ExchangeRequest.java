package quick.pager.shop.request.activity;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeRequest extends ManageDTO {

    private static final long serialVersionUID = -2139790759429948078L;

    private Long activityId;

    private Long ruleId;
    /**
     * pager_goods中t_goods 的id
     */
    private Long goodsId;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 活动名称
     */
    @NotNull(message = "活动名称不能为空")
    private String activityName;
    /**
     * 规则名称
     */
    private String ruleName;
    /**
     * 活动图片
     */
    @NotNull(message = "活动图片不能为空")
    private String activityImg;
    /**
     * 更新操作人
     */
    private String updateUser;

    private BigDecimal orderAmount;

}
