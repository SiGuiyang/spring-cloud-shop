package quick.pager.shop.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class PublishCouponDTO implements Serializable {
    private static final long serialVersionUID = -4690360296030962986L;

    private String phone;

    private String description;

}
