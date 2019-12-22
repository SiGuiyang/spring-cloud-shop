package quick.pager.shop.goods.request.brand;

import java.io.Serializable;
import lombok.Data;

@Data
public class GoodsBrandGroupSaveRequest implements Serializable {
    private static final long serialVersionUID = 5927681281149773666L;

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
}
