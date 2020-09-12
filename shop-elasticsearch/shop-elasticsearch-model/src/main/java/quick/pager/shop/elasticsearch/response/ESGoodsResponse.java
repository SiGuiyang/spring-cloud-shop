package quick.pager.shop.elasticsearch.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 商品ES response
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ESGoodsResponse extends BasicResponse {
    private static final long serialVersionUID = 7742591904063327621L;
}
