package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 地址
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_address")
public class Address extends Model {
    private static final long serialVersionUID = 6960557030672760699L;
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
