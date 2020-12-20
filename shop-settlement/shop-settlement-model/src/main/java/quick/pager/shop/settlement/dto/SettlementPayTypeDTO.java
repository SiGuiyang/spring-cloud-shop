package quick.pager.shop.settlement.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * 支付方式
 *
 * @author siguiyang
 */
@Data
public class SettlementPayTypeDTO implements Serializable {
    private static final long serialVersionUID = 3458378253621966616L;

    /**
     * 支付方式
     */
    private Integer payType;
    /**
     * 支付方式名称
     */
    private String name;
}
