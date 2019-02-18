package quick.pager.shop.auth.mapper;

import java.util.List;
import quick.pager.shop.model.manage.WhiteList;

public interface WhiteListMapper {

    int insertSelective(WhiteList record);

    WhiteList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WhiteList record);

    List<WhiteList> selectEnableAll();

}