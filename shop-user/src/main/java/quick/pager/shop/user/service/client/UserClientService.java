package quick.pager.shop.user.service.client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.response.Response;
import quick.pager.shop.model.feign.dto.UserInfoDTO;
import quick.pager.shop.model.user.User;
import quick.pager.shop.user.mapper.UserMapper;

/**
 * feign Client Service 服务
 */
@Service
public class UserClientService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户信息
     *
     * @param userId 用户Id集合
     */
    public List<UserInfoDTO> getUser(List<Long> userId) {
        return userMapper.selectByBatchPrimaryKey(userId);
    }


    /**
     * 根据手机号码批量获取判断用户是否存在
     * @param phones 手机号集合
     */
    public Response<List<User>> isExists(List<String> phones) {
        return new Response<>(userMapper.isExists(phones));
    }
}
