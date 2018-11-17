package quick.pager.shop.user.mapper;

import java.util.List;
import quick.pager.shop.model.user.Area;

public interface AreaMapper {

    int insertSelective(Area record);

    Area selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Area record);

    /**
     * 查询所有
     */
    List<Area> selectAll();


}