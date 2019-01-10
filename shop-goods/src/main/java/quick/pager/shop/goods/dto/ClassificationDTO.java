package quick.pager.shop.goods.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassificationDTO extends DTO {
    private static final long serialVersionUID = 5354597172629077750L;

    private String className;

    private String icon;

    private String createUser;
}
