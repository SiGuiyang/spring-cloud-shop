package quick.pager.shop.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.user.model.StationLetter;

public interface StationLetterMapper extends BaseMapper<StationLetter> {
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
