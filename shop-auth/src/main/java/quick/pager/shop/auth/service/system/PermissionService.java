package quick.pager.shop.auth.service.system;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.auth.dto.AuthorizationDTO;
import quick.pager.shop.auth.mapper.RolePermissionMapper;
import quick.pager.shop.model.manage.RolePermission;

/**
 * 权限
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class PermissionService implements IService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public Response doService(BaseDTO dto) {

        AuthorizationDTO authorizationDTO = (AuthorizationDTO) dto;

        List<RolePermission> permissions = rolePermissionMapper.selectPermissions(authorizationDTO.getId()); // 历史权限
        List<Long> historyPermissions = Lists.newArrayListWithCapacity(permissions.size());
        permissions.forEach(permission -> historyPermissions.add(permission.getId()));

        List<Long> copyHistoryPermissions = Lists.newArrayListWithCapacity(historyPermissions.size()); // 拷贝权限

        List<Long> permissionIds = JSON.parseArray(authorizationDTO.getPermissions(), Long.class); // 最新选择要授权的权限

        historyPermissions.removeAll(permissionIds); // 剩余下值是取消的权限

        permissionIds.removeAll(copyHistoryPermissions); // 剩下的值是新增的权限


        // 删除取消的权限
        List<RolePermission> deleteRolePermission = Lists.newArrayList();
        historyPermissions.forEach(hps -> {
            permissions.forEach(p -> {
                if (hps.compareTo(p.getPermissionId()) == 0) {
                    deleteRolePermission.add(p);
                }
            });
        });

        deleteRolePermission.forEach(p -> {
            p.setDeleteStatus(true);
            rolePermissionMapper.updateByPrimaryKeySelective(p);
        });

        // 新增权限
        permissionIds.forEach(p -> {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setDeleteStatus(false);
            rolePermission.setPermissionId(p);
            rolePermission.setRoleId(authorizationDTO.getId());
            rolePermission.setCreateTime(new Date());
            rolePermissionMapper.insertSelective(rolePermission);
        });


        return new Response();
    }

    public static void main(String[] args) {
        List<Integer> all = Lists.newArrayList();
        all.add(1);
        all.add(2);
        all.add(3);
        all.add(4);
        all.add(5);
        all.add(6);
        List<Integer> p = Lists.newArrayList();
        p.add(1);
        p.add(2);
        p.add(3);
        p.add(4);
        p.add(18);
        p.add(19);

        List<Integer> re = Lists.newArrayList(all);

        all.removeAll(p);
        System.out.println(all);
        p.removeAll(re);
        System.out.println(p);
    }
}
