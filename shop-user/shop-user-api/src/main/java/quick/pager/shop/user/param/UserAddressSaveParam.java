package quick.pager.shop.user.param;

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
public class UserAddressSaveParam extends Param {
    private static final long serialVersionUID = 7541385864522318701L;

    private Long id;

    private Long userId;

    private String phone;

    private String username;

    private String area;

    private String detailAddress;

    private String label;

    private Boolean defaultAddress;

    private String latitude;

    private String longitude;
}
