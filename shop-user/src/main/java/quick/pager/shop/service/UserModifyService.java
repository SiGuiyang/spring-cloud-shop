package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.user.UserInfoDTO;
import quick.pager.shop.mapper.UserInfoMapper;
import quick.pager.shop.model.UserInfo;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.DateUtils;

/**
 * 修改用户信息服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class UserModifyService implements IService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Response doService(BaseDTO dto) {

        UserInfoDTO userInfoDTO = (UserInfoDTO) dto;

        UserInfo userInfo = userInfoMapper.selectByUserId(userInfoDTO.getUserId());

        if (ObjectUtils.isEmpty(userInfo)) {
            userInfo = new UserInfo();

            userInfo.setAge(userInfoDTO.getAge());
            userInfo.setBirthday(userInfoDTO.getBirthday());
            userInfo.setAvatar(userInfoDTO.getAvatar());
            userInfo.setEmail(userInfoDTO.getEmail());
            userInfo.setGender(userInfoDTO.getGender());
            userInfo.setUsername(userInfoDTO.getUsername());
            userInfo.setCreateTime(DateUtils.now());
            userInfo.setDeleteStatus(false);
            userInfoMapper.insertSelective(userInfo);
        } else {
            UserInfo updateUserInfo = new UserInfo();

            updateUserInfo.setId(userInfo.getId());
            updateUserInfo.setAge(userInfoDTO.getAge());
            updateUserInfo.setBirthday(userInfoDTO.getBirthday());
            updateUserInfo.setAvatar(userInfoDTO.getAvatar());
            updateUserInfo.setEmail(userInfoDTO.getEmail());
            updateUserInfo.setGender(userInfoDTO.getGender());
            updateUserInfo.setUsername(userInfoDTO.getUsername());

            userInfoMapper.updateByPrimaryKeySelective(updateUserInfo);
        }


        return new Response();
    }
}
