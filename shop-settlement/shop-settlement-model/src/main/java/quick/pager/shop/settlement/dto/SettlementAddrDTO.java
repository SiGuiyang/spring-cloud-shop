package quick.pager.shop.settlement.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * 清结算返回默认地址
 *
 * @author siguiyang
 */
@Data
public class SettlementAddrDTO implements Serializable {
    private static final long serialVersionUID = 6894518970111252219L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 地址明细
     */
    private String addrName;
    /**
     * 地址标签
     */
    private String label;

    private Boolean defaultAddress;
}
