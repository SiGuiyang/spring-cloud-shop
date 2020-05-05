package quick.pager.shop.goods.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.response.BasicResponse;

/**
 * 商品主表信息
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsResponse extends BasicResponse {
    private static final long serialVersionUID = 6556034472603049318L;

    private Long id;
    /**
     * 品牌主键
     */
    private Long brandId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 商品二级分类主键
     */
    private Long gcsId;
    /**
     * 商品分类名称
     */
    private String gcsName;
    /**
     * 商品属性组主键
     */
    private Long goodsPropertyGroupId;
    /**
     * spu 主键
     */
    private Long spuId;
    /**
     * spu名称
     */
    private String spuName;
    /**
     * 商品属性组名称
     */
    private String goodsPropertyGroupName;
    /**
     * 商品主表名称
     */
    private String name;
    /**
     * 商品状态 0 未上架 1 上架申请 2 上架 3 已下架
     */
    private Integer publishStatus;
    /**
     * 商品状态名称
     */
    private String publishStatusName;
    /**
     * 商品类型
     */
    private Integer goodsType;
    /**
     * 商品类型名称
     */
    private String goodsTypeName;
    /**
     * 新品状态:0->不是新品；1->新品
     */
    private Boolean state;
    /**
     * 新品状态名称
     */
    private String stateName;
    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    private Boolean recommend;
    /**
     * 推荐状态名称
     */
    private String recommendName;
    /**
     * 商品单位
     */
    private String unit;
    /**
     * 商品描述
     */
    private String description;
}
