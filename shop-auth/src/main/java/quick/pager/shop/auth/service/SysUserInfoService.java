package quick.pager.shop.auth.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.common.service.RedisService;
import quick.pager.shop.auth.mapper.SysUserMapper;
import quick.pager.shop.auth.dto.LoginDTO;
import quick.pager.shop.auth.mapper.PermissionMapper;
import quick.pager.shop.auth.response.SysUserResponse;
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
    @Autowired
    private RedisService redisService;

    @Override
    public Response<SysUserResponse> doService(BaseDTO dto) {

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

        Map<Long, String> map = permissions.stream().collect(Collectors.toMap(Permission::getId, Permission::getPermission, (k1, k2) -> k1));

        redisService.setMapOps(sysUser.getSysCode(), map);

        response.setData(sysUserResponse);

        return response;
    }
}
