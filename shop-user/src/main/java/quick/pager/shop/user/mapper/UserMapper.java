package quick.pager.shop.user.mapper;

import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.user.User;
import quick.pager.shop.user.dto.UserInfoDTO;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    /**
     * 根据手机号查询用户
     *
     * @param phone 手机号
     */
    User selectByPhone(@Param("phone") String phone);

    /**
     * 根据手机号查询用户
     *
     * @param phone 手机号
     */
    UserInfoDTO selectInfoByPhone(@Param("phone") String phone);
}