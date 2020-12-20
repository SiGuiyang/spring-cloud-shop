package quick.pager.shop.user.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址
 *
 * @author siguiyang
 * @version 3.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse implements Serializable {
    private static final long serialVersionUID = -6008528883711697457L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 联系人手机号码
     */
    private String mobile;
    /**
     * 收货人姓名
     */
    private String username;
    /**
     * 所在城市
     */
    private String cityName;
    /**
     * 收货地址
     * 配送地址
     */
    private String deliveryAddress;
    /**
     * 门牌号
     */
    private String houseNumber;
    /**
     * 标签
     */
    private String label;
    /**
     * 是否是默认地址
     */
    private Boolean defaultAddress;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 经度
     */
    private String longitude;
}
