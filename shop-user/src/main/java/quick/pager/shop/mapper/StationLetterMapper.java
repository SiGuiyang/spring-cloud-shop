package quick.pager.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.StationLetter;

@Mapper
public interface StationLetterMapper {
    int insertSelective(StationLetter record);

    StationLetter selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StationLetter record);

    List<StationLetter> selectStationMessages(@Param("userId") Long userId, @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    int selectUnReadMessageCount(@Param("userId") Long userId);

    /**
     * 管理后台查询站内信列表
     *
     * @param phone 手机号
     */
    List<StationLetter> selectStationMessagesByPhone(@Param("phone") String phone);
}
