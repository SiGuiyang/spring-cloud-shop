package quick.pager.shop.manage.service.system;

import java.util.List;
import quick.pager.shop.manage.param.system.RoleParam;
import quick.pager.shop.manage.response.PermissionResponse;
import quick.pager.shop.manage.model.Role;
import quick.pager.shop.response.Response;

/**
 * 角色服务
 *
 * @author siguiyang
 * @version 3.0
 */
public interface RoleService {

    /**
     * 查询列表
     */
    Response<List<Role>> queryPage(RoleParam param);

    /**
     * 查询列表，无分页
     */
    Response<List<Role>> queryList(RoleParam param);

    /**
     * 新增
     */
    Response<Long> create(RoleParam param);

    /**
     * 修改
     */
    Response<Long> modify(RoleParam param);

    /**
     * 删除
     *
     * @param id 主键
     */
    Response<Long> delete(Long id);

    /**
     * 查询角色的权限
     *
     * @param roleId 角色主键
     */
    Response<PermissionResponse> queryRolePermission(Long roleId);

}
