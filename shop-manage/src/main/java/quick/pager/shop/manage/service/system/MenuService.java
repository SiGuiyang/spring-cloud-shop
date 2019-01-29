package quick.pager.shop.manage.service.system;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.manage.mapper.PermissionMapper;
import quick.pager.shop.model.manage.Permission;

/**
 * 权限菜单列表
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class MenuService implements IService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Response doService(BaseDTO dto) {


        List<Permission> topMenu = permissionMapper.selectTopMenu();

        List<Permission> result = Lists.newArrayList();

        Response<List<Permission>> response = new Response<>();

        response.setData(recursivePermission(result, topMenu));

        return response;
    }

    /**
     * 递归迭代权限菜单列表
     *
     * @param result      菜单集合结果
     * @param permissions 权限菜单
     */
    private List<Permission> recursivePermission(List<Permission> result, List<Permission> permissions) {

        permissions.forEach(k -> {
            List<Permission> list = recursivePermission(Lists.newArrayList(), permissionMapper.selectSubMenu(k.getId()));
            if (!CollectionUtils.isEmpty(list)) {
                k.setChildren(list);
            }
            if (k.getPermissionType() == 1) {
                k.setPermissionTypeName("目录");
            } else if (k.getPermissionType() == 2) {
                k.setPermissionTypeName("菜单");
            } else {
                k.setPermissionTypeName("按钮");
            }
            k.setCreateTimeName(DateUtil.formatDateTime(k.getCreateTime()));
            result.add(k);
        });
        return result;
    }
}
