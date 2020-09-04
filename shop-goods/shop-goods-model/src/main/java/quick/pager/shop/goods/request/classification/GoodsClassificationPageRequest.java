package quick.pager.shop.goods.request.classification;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 商品分类
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsClassificationPageRequest extends PageRequest {
    private static final long serialVersionUID = -2963591326963007336L;
    /**
     * 分类名称
     */
    private String className;
}
