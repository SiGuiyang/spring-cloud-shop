package quick.pager.shop.model;

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
public class Address extends Model {
    private static final long serialVersionUID = 6960557030672760699L;

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
