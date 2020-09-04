package quick.pager.shop.goods.request.brand;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandGroupPageRequest extends PageRequest {

    private static final long serialVersionUID = -2957182385944264369L;
    /**
     * t_goods_brand_group 主键
     */
    private Long brandGroupId;
    /**
     * 品牌组名称
     */
    private String brandGroupName;
    /**
     * 序号
     */
    private Integer sequence;

    private List<LocalDateTime> dateTimes;
}
