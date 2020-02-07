package quick.pager.shop.manage.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.manage.mapper.MenuMapper;
import quick.pager.shop.manage.model.Menu;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.mapper.SysUserMapper;
import quick.pager.shop.manage.model.SysUser;

@Service
public class SysUserClientService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private MenuMapper menuMapper;

    public Response<SysUser> querySysUserByUsername(String phone) {
        SysUser sysUser = new SysUser();
        sysUser.setDeleteStatus(Boolean.FALSE);
        sysUser.setPhone(phone);
        return new Response<>(sysUserMapper.selectOne(new QueryWrapper<>(sysUser)));
    }

    public Response<List<String>> getRolesBySysUserId(Long sysUserId) {

        // 所有访问菜单的路由
        List<Menu> menus = menuMapper.selectMenuBySysUserId(sysUserId);
        return new Response<>(Optional.of(menus).orElse(Collections.emptyList()).stream()
                .filter(menu -> !StringUtils.isEmpty(menu.getPermission()))
                .map(Menu::getPermission)
                .distinct()
                .collect(Collectors.toList()));
    }
}
