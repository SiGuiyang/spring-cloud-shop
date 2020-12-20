package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
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
     * 商品二级分类主键
     */
    private Long goodsClassId;
    /**
     * 商品状态 0 未上架 1 上架申请 2 上架 3 已下架
     *
     * @see quick.pager.shop.goods.enums.GoodsPublishStatusEnum
     */
    private Integer publishStatus;
    /**
     * 商品类型
     */
    private Integer goodsType;
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
}
