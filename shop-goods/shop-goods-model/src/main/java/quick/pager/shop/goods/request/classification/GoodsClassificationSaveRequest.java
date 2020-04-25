package quick.pager.shop.goods.request.classification;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.Request;

/**
 * 商品分类
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsClassificationSaveRequest extends Request {
    private static final long serialVersionUID = 6958547173183868641L;
    /**
     * 分类名称
     */
    private String className;
    /**
     * 父级主键
     */
    private Long parentId;
    /**
     * banner主键
     */
    private Long bannerId;

}
