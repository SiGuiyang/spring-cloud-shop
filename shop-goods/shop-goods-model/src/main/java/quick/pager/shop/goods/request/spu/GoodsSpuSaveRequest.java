package quick.pager.shop.goods.request.spu;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 商品spu
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSpuSaveRequest extends Request {
    private static final long serialVersionUID = 1503736057365965232L;


    /**
     * 分类 t_goods_class id 这个分类必须是二级分类，不可是顶级分类
     */
    private Long classificationId;

    /**
     * spu 名称
     */
    private String spuName;

    /**
     * spu 图片
     */
    private String spuImage;

    /**
     * 序号
     */
    private Integer sequence;
}
