package quick.pager.shop.service.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.StationLetter;
import quick.pager.shop.User;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.UserInfoDTO;
import quick.pager.shop.common.Address;
import quick.pager.shop.mapper.AddressMapper;
import quick.pager.shop.mapper.StationLetterMapper;
import quick.pager.shop.mapper.UserMapper;

/**
 * feign Client Service 服务
 */
@Service
public class UserClientService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private StationLetterMapper stationLetterMapper;

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
     *
     * @param phones 手机号集合
     */
    public Response<List<User>> isExists(List<String> phones) {
        return new Response<>(userMapper.isExists(phones));
    }

    /**
     * 获取批量用户地址
     */
    public Response<Address> queryAddress(Long addressId) {
        return new Response<>(addressMapper.selectByPrimaryKey(addressId));
    }

    /**
     * 查询站内信列表
     *
     * @param phone 手机号
     */
    public Response<List<StationLetter>> queryStationLetter(String phone, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<StationLetter> stationLetters = stationLetterMapper.selectStationMessagesByPhone(phone);

        PageInfo<StationLetter> pageInfo = new PageInfo<>(stationLetters);

        Response<List<StationLetter>> response = new Response<>();
        response.setData(pageInfo.getList());
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    /**
     * 根据手机号查询用户信息
     *
     * @param phone 手机号
     */
    public Response<UserInfoDTO> queryUserProfile(String phone) {
        return new Response<>(userMapper.selectInfoByPhone(phone));
    }
}
