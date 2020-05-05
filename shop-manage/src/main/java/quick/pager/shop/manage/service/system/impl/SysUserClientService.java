package quick.pager.shop.manage.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.manage.helper.MenuHelper;
import quick.pager.shop.manage.model.Menu;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.mapper.SysUserMapper;
import quick.pager.shop.manage.model.SysUser;

/**
 * 用户信息
 *
 * @author siguiyang
 */
@Service
public class SysUserClientService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private MenuHelper menuHelper;

    public Response<SysUser> querySysUserByUsername(String phone) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getDeleteStatus, Boolean.FALSE);
        wrapper.eq(SysUser::getPhone, phone);
        return new Response<>(sysUserMapper.selectOne(wrapper));
    }

    public Response<List<String>> getRolesBySysUserId(Long sysUserId) {


        List<Menu> menuList = menuHelper.selectMenuBySysUserId(sysUserId);
        if (CollectionUtils.isEmpty(menuList)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "没有权限访问");
        }

        return new Response<>(menuList.stream().map(Menu::getPermission).collect(Collectors.toList()));
    }
}
