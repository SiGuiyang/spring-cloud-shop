package quick.pager.shop.elasticsearch.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 商户订单分页查询request
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ESSellerOrderPageRequest extends PageRequest {
    private static final long serialVersionUID = 1908293266205560247L;
}
