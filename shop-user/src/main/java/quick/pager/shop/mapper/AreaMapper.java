package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.Area;

@Mapper
public interface AreaMapper {

    int insertSelective(Area record);

    Area selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Area record);

    /**
     * 查询所有
     */
    List<Area> selectAll();


}
