package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品主表
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_goods")
public class Goods extends Model {
    private static final long serialVersionUID = -7898238729483065751L;
    /**
     * 品牌主键
     */
    private Long brandId;
    /**
     * 商品二级分类主键
     */
    private Long gcsId;
    /**
     * 商品属性组主键
     */
    private Long goodsPropertyGroupId;
    /**
     * spu 主键
     */
    private Long spuId;
    /**
     * 商品主表名称
     */
    private String name;
    /**
     * 商品状态 0 未上架 1 上架申请 2 上架 3 已下架
     */
    private Integer publishStatus;
    /**
     * 商品类型
     */
    private Integer goodsType;
    /**
     * 新品状态:0->不是新品；1->新品
     */
    private Boolean state;
    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    private Boolean recommend;
    /**
     * 商品单位
     */
    private String unit;
    /**
     * 商品描述
     */
    private String description;
}
