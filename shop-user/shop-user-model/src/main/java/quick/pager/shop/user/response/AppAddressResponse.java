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
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppAddressResponse implements Serializable {
    private static final long serialVersionUID = 4902247644947125410L;


    /**
     * 主键
     */
    private Long id;
    /**
     * 联系人手机号码
     */
    private String tel;
    /**
     * 收货人姓名
     */
    private String name;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 是否默认
     */
    private Boolean isDefault;
}
