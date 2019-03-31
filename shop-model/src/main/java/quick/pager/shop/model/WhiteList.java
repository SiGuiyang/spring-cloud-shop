package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WhiteList extends Model {

    private static final long serialVersionUID = -2375283737278745339L;

    private String whiteUrl;

    private String description;
}