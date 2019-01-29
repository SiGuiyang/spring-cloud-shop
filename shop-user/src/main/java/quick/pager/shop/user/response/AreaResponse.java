package quick.pager.shop.user.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.user.Area;
import quick.pager.shop.model.user.City;
import quick.pager.shop.model.user.Province;

@Data
public class AreaResponse implements Serializable {
    private static final long serialVersionUID = 8249190392975362784L;

    private List<Province> provinces;

    private List<City> cities;

    private List<Area> areas;

}
