package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 地址保存
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAddressSaveRequest extends Request {
    private static final long serialVersionUID = 7541385864522318701L;

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
