package quick.pager.shop.model.common;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfig extends Model {
    private static final long serialVersionUID = 975311331952447054L;

    private String configName;

    private String configValue;

    private String module;

    private String description;

}