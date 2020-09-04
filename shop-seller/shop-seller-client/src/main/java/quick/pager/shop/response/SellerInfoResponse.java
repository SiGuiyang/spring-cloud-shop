package quick.pager.shop.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 商户详情
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SellerInfoResponse extends BasicResponse {
    private static final long serialVersionUID = 4463151693132197632L;

    private Long id;

    private String phone;

    private String sellerName;

    private String address;

    private Integer sellerStatus;

    private String logo;

    private String longitude;

    private String latitude;
}
