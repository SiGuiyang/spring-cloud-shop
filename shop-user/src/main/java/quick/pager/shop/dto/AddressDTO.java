package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.AppDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressDTO extends AppDTO {
    private static final long serialVersionUID = -7357193842467214331L;
    /**
     * 收货人姓名
     */
    private String username;
    /**
     * 所在地区
     */
    private String area;
    /**
     * 详细地址
     */
    private String detailAddress;
    /**
     * 标签
     */
    private String label;
    /**
     * 是否默认地址标志
     * true：默认地址
     * false：不是默认地址
     */
    private Boolean defaultAddress;


}
