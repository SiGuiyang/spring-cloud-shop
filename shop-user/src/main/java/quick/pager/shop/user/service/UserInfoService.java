package quick.pager.shop.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.model.user.User;
import quick.pager.shop.model.user.UserInfo;
import quick.pager.shop.model.feign.dto.UserInfoDTO;
import quick.pager.shop.user.mapper.UserInfoMapper;
import quick.pager.shop.user.mapper.UserMapper;
import quick.pager.shop.user.response.UserInfoResponse;

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
    public Response<UserInfoResponse> doService(DTO dto) {

        UserInfoDTO userInfoDTO = (UserInfoDTO) dto;

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userInfoDTO.getId());

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
