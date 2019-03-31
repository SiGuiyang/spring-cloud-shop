package quick.pager.shop.service.system;

import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.LoginDTO;
import quick.pager.shop.mapper.SysUserMapper;
import quick.pager.shop.response.SysUserResponse;
import quick.pager.shop.model.SysUser;
import quick.pager.shop.utils.PrincipalUtils;

/**
 * 用户信息| 包含权限
 */
@Service
@Slf4j
public class SysUserInfoService implements IService<SysUserResponse> {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Response<SysUserResponse> doService(BaseDTO dto) {

        LoginDTO loginDTO = (LoginDTO) dto;

        Response<SysUserResponse> response = new Response<>();

        SysUser sysUser = sysUserMapper.selectSysUserByUsername(loginDTO.getUsername());

        if (ObjectUtils.isEmpty(sysUser)) {
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg(ResponseStatus.USER_PHONE_NOT_EXISTS);
            return response;
        }

        // 登陆用户所有角色
        Collection<? extends GrantedAuthority> authorities = PrincipalUtils.getPrincipal().getAuthorities();
        SysUserResponse sysUserResponse = new SysUserResponse();
        authorities.forEach(auth -> sysUserResponse.getPermission().add(auth.getAuthority()));

        sysUserResponse.setSysCode(sysUser.getUsername());
        sysUserResponse.setSysName(sysUser.getSysName());

        response.setData(sysUserResponse);

        return response;
    }
}
