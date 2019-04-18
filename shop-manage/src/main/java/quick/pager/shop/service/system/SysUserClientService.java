package quick.pager.shop.service.system;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.model.Menu;
import quick.pager.shop.response.Response;
import quick.pager.shop.mapper.SysUserMapper;
import quick.pager.shop.model.SysUser;

@Service
public class SysUserClientService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private MenuMapper menuMapper;

    public Response<SysUser> querySysUserByUsername(String username) {
        return new Response<>(sysUserMapper.selectSysUserByUsername(username));
    }

    public Response<List<String>> getRolesBySysUserId(Long sysUserId) {

        // 所有访问菜单的路由
        List<Menu> menus = menuMapper.selectMenuBySysUserId(sysUserId);
        List<String> list = Optional.of(menus).orElse(Collections.emptyList()).stream().map(Menu::getPermission).collect(Collectors.toList());
        return new Response<>(list);
    }
}
