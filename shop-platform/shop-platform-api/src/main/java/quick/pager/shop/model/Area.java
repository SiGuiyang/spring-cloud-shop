package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Area extends Model {

    private static final long serialVersionUID = 6688391923586576669L;

    private String areaCode;

    private String areaName;

    private String parentAreaCode;

}
