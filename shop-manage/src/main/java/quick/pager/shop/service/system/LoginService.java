package quick.pager.shop.service.system;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.LoginDTO;
import quick.pager.shop.mapper.SysUserMapper;
import quick.pager.shop.response.LoginResponse;
import quick.pager.shop.model.SysUser;

/**
 * 登陆服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class LoginService implements IService<LoginResponse> {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Response<LoginResponse> doService(BaseDTO dto) {

        LoginDTO loginDTO = (LoginDTO) dto;

        Response<LoginResponse> response = new Response<>();

        SysUser sysUser = sysUserMapper.selectSysUserByUsername(loginDTO.getUsername());

        if (ObjectUtils.isEmpty(sysUser)) {
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg(ResponseStatus.USER_PHONE_NOT_EXISTS);
            return response;
        }

        if (!SecureUtil.md5(loginDTO.getPassword()).equals(sysUser.getPassword())) {
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg(ResponseStatus.USER_ACCOUNT_PASSWORD_NOT_CORRECT);
            return response;
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setPhone(loginDTO.getPhone());
        loginResponse.setUsername(sysUser.getUsername());
        response.setData(loginResponse);

        return response;
    }
}
