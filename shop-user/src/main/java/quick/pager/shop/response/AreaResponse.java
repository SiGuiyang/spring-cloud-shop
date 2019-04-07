package quick.pager.shop.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import quick.pager.shop.model.Province;
import quick.pager.shop.model.Area;
import quick.pager.shop.model.City;

@Data
public class AreaResponse implements Serializable {
    private static final long serialVersionUID = 8249190392975362784L;

    private List<Province> provinces;

    private List<City> cities;

    private List<Area> areas;

}
