package quick.pager.shop.user.response;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;
import quick.pager.shop.model.user.Area;
import quick.pager.shop.model.user.City;
import quick.pager.shop.model.user.Province;

@EqualsAndHashCode(callSuper = true)
@Data
public class AreaResponse extends DTO {
    private static final long serialVersionUID = 8249190392975362784L;

    private List<Province> provinces;

    private List<City> cities;

    private List<Area> areas;

}
