package quick.pager.shop.platform.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.platform.model.City;

@Mapper
public interface CityMapper {

    int insertSelective(City record);

    City selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(City record);

    List<City> selectAll();

}
