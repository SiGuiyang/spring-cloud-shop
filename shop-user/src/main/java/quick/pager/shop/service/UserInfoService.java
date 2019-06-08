package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.model.User;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.response.UserInfoResponse;
import quick.pager.shop.dto.UserInfoDTO;
import quick.pager.shop.model.UserInfo;
import quick.pager.shop.mapper.UserInfoMapper;
import quick.pager.shop.mapper.UserMapper;

/**
 * 用户信息
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class UserInfoService implements IService<UserInfoResponse> {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Response<UserInfoResponse> doService(BaseDTO dto) {

        UserInfoDTO userInfoDTO = (UserInfoDTO) dto;

        UserInfo userInfo = userInfoMapper.selectByUserId(userInfoDTO.getUserId());

        if (ObjectUtils.isEmpty(userInfo)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_PHONE_NOT_EXISTS);
        }

        User user = userMapper.selectByPrimaryKey(userInfo.getUserId());

        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setAge(userInfo.getAge());
        userInfoResponse.setAvatar(userInfo.getAvatar());
        userInfoResponse.setBirthday(userInfo.getBirthday());
        userInfoResponse.setEmail(userInfo.getEmail());
        userInfoResponse.setGender(userInfo.getGender());
        userInfoResponse.setPhone(user.getPhone());
        userInfoResponse.setUsername(userInfo.getUsername());
        userInfoResponse.setUserId(user.getId());

        return new Response<>(userInfoResponse);
    }
}
