package quick.pager.shop.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfigDTO extends ManageDTO {
    private static final long serialVersionUID = -5469712897215941464L;

    @NotBlank(message = "配置项名称不能为空")
    private String configName;
    @NotBlank(message = "配置项类型不能为空")
    private String configType;
    @NotBlank(message = "配置项值不能为空")
    private String configValue;
    @NotBlank(message = "配置项模块不能为空")
    private String module;

    private String description;

}
