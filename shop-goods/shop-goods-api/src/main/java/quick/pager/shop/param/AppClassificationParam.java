package quick.pager.shop.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AppClassificationParam extends Param {
    private static final long serialVersionUID = 8663137928076712426L;
    /**
     * 分类主键
     */
    private Long classificationId;

}
