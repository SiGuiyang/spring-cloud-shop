package quick.pager.shop.user.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class Address extends Model {
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
