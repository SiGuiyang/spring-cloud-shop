package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Columns extends Model {

    private static final long serialVersionUID = -782010020592372403L;

    private String tableSchema;

    private String tableName;

    private String columnName;

    private String dataType;

    private String columnType;

    private String columnKey;

    private String columnComment;

    private String columnTitle;

    private boolean columnDisplay;

    private boolean queryDisplay;


}
