package quick.pager.shop.service.system;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.RoleMapper;
import quick.pager.shop.model.Role;
import quick.pager.shop.response.Response;
import quick.pager.shop.mapper.SysUserMapper;
import quick.pager.shop.model.SysUser;

@Service
public class SysUserClientService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RoleMapper roleMapper;

    public Response<SysUser> querySysUserByUsername(String username) {
        return new Response<>(sysUserMapper.selectSysUserByUsername(username));
    }

    public Response<List<Role>> getRolesBySysUserId(Long sysUserId) {
        return new Response<>(roleMapper.selectRoleBySysUserId(sysUserId));
    }
}
