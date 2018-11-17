package quick.pager.shop.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class City extends Model {

    private static final long serialVersionUID = 1729543874328195311L;

    private String cityCode;

    private String cityName;

    private String parentCityCode;

}