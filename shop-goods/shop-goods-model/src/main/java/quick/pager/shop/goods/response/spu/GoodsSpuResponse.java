package quick.pager.shop.goods.response.spu;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.response.BasicResponse;

/**
 * 商品spu
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSpuResponse extends BasicResponse {
    private static final long serialVersionUID = 8393377609491652196L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 分类 t_goods_class id 这个分类必须是二级分类，不可是顶级分类
     */
    private Long classId;

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
