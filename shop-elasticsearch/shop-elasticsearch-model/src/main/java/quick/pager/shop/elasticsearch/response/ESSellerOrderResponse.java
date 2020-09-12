package quick.pager.shop.elasticsearch.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 商户ES订单response
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ESSellerOrderResponse extends BasicResponse {
    private static final long serialVersionUID = -7648146194412951304L;
}
