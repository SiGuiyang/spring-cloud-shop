package quick.pager.shop.activity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.Banner;

public interface BannerMapper {

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    /**
     * 查询所有banner
     *
     * @param title      活动标题
     * @param bannerType banner 类型
     */
    List<Banner> selectBanner(@Param("title") String title, @Param("bannerType") String bannerType);

}