package quick.pager.shop.goods.request.brand;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 商品组
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandGroupOtherRequest extends Request {
    private static final long serialVersionUID = -5473796536091298931L;

    /**
     * 品牌组名称
     */
    private String brandGroupName;
}
