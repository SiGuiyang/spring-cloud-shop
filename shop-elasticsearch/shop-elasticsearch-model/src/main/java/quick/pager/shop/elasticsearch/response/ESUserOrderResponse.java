package quick.pager.shop.elasticsearch.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 用户ES订单request
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ESUserOrderResponse extends BasicResponse {
    private static final long serialVersionUID = -7121250332569972501L;
}
