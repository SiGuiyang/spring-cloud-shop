package quick.pager.shop.goods.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.goods.dto.UploadDTO;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 商品主表信息
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsResponse extends BasicResponse {
    private static final long serialVersionUID = 6556034472603049318L;

    /**
     * 商品主表主键
     */
    private Long id;
    /**
     * sku主键
     */
    private Long skuId;
    /**
     * 商品二级分类主键
     */
    private List<Long> goodsClassId;
    /**
     * sku图片集
     */
    private List<UploadDTO> images;
    /**
     * 商品分类名称
     */
    private String skuName;
    /**
     * spu分类名称
     */
    private String spuName;
    /**
     * sku 编码
     */
    private String skuCode;
    /**
     * 含重量
     */
    private BigDecimal weight;
    /**
     * 商品价格
     */
    private BigDecimal skuAmount;
    /**
     * 折扣价格
     */
    private BigDecimal discountAmount;
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
     * 商品库存
     */
    private Integer stock;
    /**
     * 商品类型名称
     */
    private String goodsTypeName;
    /**
     * 新品状态:0 下架；1->上架
     */
    private Boolean state;
    /**
     * 新品状态:0->不是新品；1->新品
     */
    private Boolean goodsState;
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
     * 开始时间
     */
    private LocalDate beginTime;
    /**
     * 结束时间（过期时间）
     */
    private LocalDate endTime;
    /**
     * 商品描述
     */
    private String description;
}
