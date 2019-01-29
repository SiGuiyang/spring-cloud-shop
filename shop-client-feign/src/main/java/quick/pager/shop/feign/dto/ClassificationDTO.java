package quick.pager.shop.feign.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.ManageDTO;
import quick.pager.common.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassificationDTO extends ManageDTO {
    private static final long serialVersionUID = 8834227650288882046L;

    private String className;

    private String icon;

}
