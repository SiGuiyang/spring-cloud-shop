package quick.pager.shop.goods.request.classification;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

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
     * spu主键
     */
    private Long spuId;
    /**
     * 序号
     */
    private Integer sequence;

}
