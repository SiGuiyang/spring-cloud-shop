package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassificationDTO extends BaseDTO {
    private static final long serialVersionUID = 5354597172629077750L;

    /**
     * 商品父级Id
     */
    private Long parentId;
    /**
     * 分类名称
     */
    private String className;
    /**
     * 分类图标
     */
    private String icon;

}
