package quick.pager.shop.goods.response.classification;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import quick.pager.shop.user.response.CommonResponse;

/**
 * 分类详情
 *
 * @author siguiyang
 */
@Data
public class AppGoodsClassificationDetailResponse implements Serializable {
    private static final long serialVersionUID = 1700041614051493637L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 对应的父级分类
     * APP 左侧的分类主键
     */
    private Long classificationId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类详情
     */
    private List<CommonResponse> spus;
}
