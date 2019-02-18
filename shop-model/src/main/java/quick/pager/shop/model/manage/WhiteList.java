package quick.pager.shop.model.manage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class WhiteList extends Model {

    private static final long serialVersionUID = -2375283737278745339L;

    private String whiteUrl;

    private String description;
}