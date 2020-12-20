package quick.pager.shop.settlement.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 配送时间
 *
 * @author siguiyang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettlementDeliveryTimeDTO implements Serializable {
    private static final long serialVersionUID = -240749099279144044L;

    /**
     * 配送周期
     */
    private List<String> deliveryTime;
    /**
     * 配送时间
     */
    private String name;
}
