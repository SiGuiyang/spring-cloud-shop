package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;
import quick.pager.shop.model.Model;

/**
 * ES商品
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Document(indexName = "es_goods", createIndex = false)
public class ESGoods extends Model {
    private static final long serialVersionUID = 8509683142547327975L;

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
