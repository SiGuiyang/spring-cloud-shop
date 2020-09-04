package quick.pager.shop.param.goods;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassificationPageParam extends PageParam {
    private static final long serialVersionUID = -5910768372200796406L;

    /**
     * 分类名称
     */
    private String className;
}
