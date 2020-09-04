package quick.pager.shop.goods.response.brand;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * banner 组
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandGroupResponse extends BasicResponse {

    private static final long serialVersionUID = 5963189681054756625L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 品牌组名称
     */
    private String brandGroupName;
    /**
     * 序号
     */
    private Integer sequence;
}
