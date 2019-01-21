package quick.pager.shop.manage.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfigDTO extends DTO {
    private static final long serialVersionUID = -5469712897215941464L;


    private String configName;

    private String configValue;

    private String module;

    private String description;

}
