package quick.pager.shop.goods.response.classification;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 商品分类响应对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsClassificationResponse extends BasicResponse {
    private static final long serialVersionUID = -3807725086026024155L;

    private Long id;
    /**
     * 分类名称
     */
    private String className;

    private Long spuId;

    private String spuName;
    /**
     * 序号
     */
    private Integer sequence;
}
