package quick.pager.shop.user.mapper;

import java.util.List;
import quick.pager.shop.model.user.City;

public interface CityMapper {

    int insertSelective(City record);

    City selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(City record);

    List<City> selectAll();

}