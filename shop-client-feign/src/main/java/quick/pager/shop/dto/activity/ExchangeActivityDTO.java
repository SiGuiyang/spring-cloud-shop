package quick.pager.shop.dto.activity;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityDTO extends ManageDTO {

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
