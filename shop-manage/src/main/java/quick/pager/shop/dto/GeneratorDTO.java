package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GeneratorDTO extends ManageDTO {
    private static final long serialVersionUID = 9001430976354534713L;

    private String tableName;

    private String tableSchema;


}
