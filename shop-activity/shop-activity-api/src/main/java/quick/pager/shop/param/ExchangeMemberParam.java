package quick.pager.shop.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ExchangeMemberParam implements Serializable {

    private static final long serialVersionUID = -1080852974071761086L;
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
    private LocalDateTime createTime;

}
