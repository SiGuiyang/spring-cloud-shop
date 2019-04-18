package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GeneratorConfig extends Model {
    private static final long serialVersionUID = 6767700338460801118L;
    private Long id;

    private String backendPath;

    private String frontPath;

    private Boolean serverStatus;

    private String packagePath;

    private String author;

    private String module;
}
