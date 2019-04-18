package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Tables extends Model {

    private static final long serialVersionUID = 2230728377435647289L;

    private String tableSchema;

    private String tableName;

    private String tableComment;

}
