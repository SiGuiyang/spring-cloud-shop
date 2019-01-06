package quick.pager.shop.manage.service.system;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.common.utils.PermissionMap;
import quick.pager.shop.manage.dto.LoginDTO;
import quick.pager.shop.manage.mapper.PermissionMapper;
import quick.pager.shop.manage.mapper.SysUserMapper;
import quick.pager.shop.manage.response.SysUserResponse;
import quick.pager.shop.model.manage.Permission;
import quick.pager.shop.model.manage.SysUser;

/**
 * 用户信息| 包含权限
 */
@Service
@Slf4j
public class SysUserInfoService implements IService<SysUserResponse> {

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Response<SysUserResponse> doService(DTO dto) {

        LoginDTO loginDTO = (LoginDTO) dto;

        Response<SysUserResponse> response = new Response<>();

        SysUser sysUser = sysUserMapper.selectSysUserBySysCode(loginDTO.getUsername());

        if (ObjectUtils.isEmpty(sysUser)) {
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg(ResponseStatus.USER_PHONE_NOT_EXISTS);
            return response;
        }

        List<Permission> permissions = permissionMapper.selectPermissions(sysUser.getId());
        SysUserResponse sysUserResponse = new SysUserResponse();

        sysUserResponse.setAvatar(sysUser.getAvatar());
        sysUserResponse.setSysCode(sysUser.getSysCode());
        sysUserResponse.setSysName(sysUser.getSysName());
        permissions.forEach(permission -> {
            sysUserResponse.getPermission().add(permission.getPermission());
        });

        PermissionMap.put(sysUser.getSysCode(), sysUserResponse.getPermission());

        response.setData(sysUserResponse);

        return response;
    }
}
