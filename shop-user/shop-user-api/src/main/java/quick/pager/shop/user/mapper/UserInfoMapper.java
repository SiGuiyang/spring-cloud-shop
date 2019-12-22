package quick.pager.shop.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.user.model.UserInfo;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * 根据用户Id查询用户信息
     *
     * @param userId 用户Id
     */
    UserInfo selectByUserId(@Param("userId") Long userId);
}
