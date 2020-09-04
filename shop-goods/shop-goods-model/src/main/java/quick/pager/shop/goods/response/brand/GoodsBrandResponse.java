package quick.pager.shop.goods.response.brand;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 品牌组
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandResponse extends BasicResponse {
    private static final long serialVersionUID = 5556556044921225757L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 品牌编码
     */
    private String brandCode;
    /**
     * 品牌组名称
     */
    private String brandGroupName;
    /**
     * 品牌图标
     */
    private String icon;

    /**
     * 序号
     */
    private Integer sequence;
}
