package quick.pager.shop.goods.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 商品搜索请求类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSearchRequest extends Request {
    private static final long serialVersionUID = 6685702979479512148L;

    private String goodsName;
}
