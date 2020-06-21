package quick.pager.shop.user.param;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 地址
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddressParam extends Param {
    private static final long serialVersionUID = -7357193842467214331L;
    /**
     * 收货人姓名
     */
    @NotBlank(message = "收货人姓名不能为空")
    private String username;
    /**
     * 所在地区
     */
    private String area;
    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空")
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
