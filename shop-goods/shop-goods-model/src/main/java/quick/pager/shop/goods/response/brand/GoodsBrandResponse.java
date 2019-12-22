package quick.pager.shop.goods.response.brand;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.response.BasicResponse;

/**
 * 品牌组
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandResponse extends BasicResponse {
    private static final long serialVersionUID = 5556556044921225757L;
    /**
     * 品牌组名称
     */
    private String brandGroupName;
}
