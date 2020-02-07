package quick.pager.shop.user.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 地址
 *
 * @author siguiyang
 * @version 3.0
 */
@Data
public class AddressResponse implements Serializable {
    private static final long serialVersionUID = -6008528883711697457L;

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
