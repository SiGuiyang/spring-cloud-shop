package quick.pager.shop.goods.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.goods.dto.UploadDTO;
import quick.pager.shop.user.request.Request;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSaveRequest extends Request {
    private static final long serialVersionUID = 8777567671838766455L;

    /**
     * sku名称
     */
    private String skuName;
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
     * 商品二级分类主键
     */
    private Long goodsClassId;
    /**
     * 商品状态 0 未上架 1 上架申请 2 上架 3 已下架
     */
    private Integer publishStatus;
    /**
     * 商品类型
     */
    private Integer goodsType;
    /**
     * 商品库存
     */
    private Integer stock;
    /**
     * 新品状态:0->不是新品；1->新品
     */
    private Boolean goodsState;
    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    private Boolean recommend;
    /**
     * 开始时间
     */
    private LocalDate beginTime;
    /**
     * 结束时间（过期时间）
     */
    private LocalDate endTime;
    /**
     * 商品单位
     */
    private String unit;
    /**
     * 商品描述
     */
    private String description;

    private List<UploadDTO> images;
}
