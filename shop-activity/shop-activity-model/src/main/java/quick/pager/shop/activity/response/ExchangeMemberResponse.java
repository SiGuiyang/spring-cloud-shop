package quick.pager.shop.activity.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class ExchangeMemberResponse implements Serializable {
    private static final long serialVersionUID = -1595741322256254277L;

    private Long id;
    private Long activityId;
    private Long ruleId;
    private Long goodsId;
    private Long userId;
    private String goodsName;
    private BigDecimal goodsAmount;
    private String phone;
    private String activityName;
    private String ruleName;

    private Date createTime;
}
