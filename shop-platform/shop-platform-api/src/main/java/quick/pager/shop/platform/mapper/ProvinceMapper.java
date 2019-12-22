package quick.pager.shop.platform.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.platform.model.Province;

@Mapper
public interface ProvinceMapper {

    int insertSelective(Province record);

    Province selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Province record);

    List<Province> selectAll();

}
