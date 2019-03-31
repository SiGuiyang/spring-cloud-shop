package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassificationDTO extends ManageDTO {
    private static final long serialVersionUID = 8834227650288882046L;

    private String className;

    private String icon;

}
