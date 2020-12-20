package quick.pager.shop.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.helper.MenuHelper;
import quick.pager.shop.model.Menu;
import quick.pager.shop.mapper.SysUserMapper;
import quick.pager.shop.model.SysUser;
import quick.pager.shop.user.response.Response;

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

    public Response<SysUser> querySysUserByUsername(final String phone) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getDeleteStatus, Boolean.FALSE)
                .eq(SysUser::getPhone, phone);
        return Response.toResponse(sysUserMapper.selectOne(wrapper));
    }

    public Response<List<String>> getRolesBySysUserId(final Long sysUserId) {


        List<Menu> menuList = menuHelper.selectMenuBySysUserId(sysUserId);
        if (CollectionUtils.isEmpty(menuList)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "没有权限访问");
        }

        return Response.toResponse(menuList.stream().map(Menu::getPermission).collect(Collectors.toList()));
    }
}
