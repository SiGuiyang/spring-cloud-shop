package quick.pager.shop.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.user.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    /**
     * 根据手机号查询用户
     *
     * @param phone 手机号
     */
    User selectByPhone(@Param("phone") String phone);
//
//    /**
//     * 根据手机号查询用户
//     *
//     * @param phone 手机号
//     */
//    UserInfoDTO selectInfoByPhone(@Param("phone") String phone);
//
//    /**
//     * 根据用户Id批量查询
//     *
//     * @param userIds
//     * @return
//     */
//    List<UserInfoDTO> selectByBatchPrimaryKey(@Param("userIds") List<Long> userIds);

    /**
     * 根据手机号查询用户
     *
     * @param phone 手机号
     */
    List<User> isExists(@Param("phones") List<String> phone);
}
