package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfig extends Model {
    private static final long serialVersionUID = 975311331952447054L;

    private String configName;

    private String configType;

    private String configValue;

    private String module;

    private String description;

}
