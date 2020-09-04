package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Province extends Model {

    private static final long serialVersionUID = 6480484321210983497L;
    private String provinceCode;

    private String provinceName;

}
