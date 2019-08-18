package quick.pager.shop.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassificationDTO extends ManageDTO {
    private static final long serialVersionUID = 8834227650288882046L;

    @NotBlank(message = "分类名称不能为空")
    private String className;

    @NotBlank(message = "分类图片不能为空")
    private String icon;

}
