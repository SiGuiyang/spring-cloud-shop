package quick.pager.shop.activity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.Banner;

public interface  BannerMapper {

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    /**
     * 查询所有banner
     */
    List<Banner> selectAll(@Param("bannerType") String bannerType);

}