package quick.pager.shop.manage.service.system;

import cn.hutool.crypto.SecureUtil;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.manage.dto.LoginDTO;
import quick.pager.shop.manage.mapper.SysUserMapper;
import quick.pager.shop.manage.response.LoginResponse;
import quick.pager.shop.model.manage.SysUser;

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
    public Response<LoginResponse> doService(DTO dto) {

        LoginDTO loginDTO = (LoginDTO) dto;

        Response<LoginResponse> response = new Response<>();

        SysUser sysUser = sysUserMapper.selectSysUserBySysCode(loginDTO.getUsername());

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
        loginResponse.setSysCode(loginDTO.getUsername());
        response.setData(loginResponse);

        return response;
    }
}