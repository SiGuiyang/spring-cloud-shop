package quick.pager.shop.mapper;

import java.util.List;
import quick.pager.shop.model.Province;

public interface ProvinceMapper {

    int insertSelective(Province record);

    Province selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Province record);

    List<Province> selectAll();

}
