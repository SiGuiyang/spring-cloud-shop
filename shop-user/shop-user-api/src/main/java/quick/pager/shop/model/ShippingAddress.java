package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 配送地址
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShippingAddress extends Model {
    private static final long serialVersionUID = 8866052323088071658L;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 用户手机号码
     */
    private String phone;
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
