package quick.pager.shop.service.system;

import java.util.List;
import quick.pager.shop.param.system.RoleOtherParam;
import quick.pager.shop.param.system.RolePageParam;
import quick.pager.shop.param.system.RoleSaveParam;
import quick.pager.shop.response.PermissionResponse;
import quick.pager.shop.response.system.RoleResponse;
import quick.pager.shop.user.response.Response;

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
    Response<List<RoleResponse>> queryPage(final RolePageParam param);

    /**
     * 查询列表，无分页
     */
    Response<List<RoleResponse>> queryList(final RoleOtherParam param);

    /**
     * 新增
     */
    Response<Long> create(final RoleSaveParam param);

    /**
     * 修改
     */
    Response<Long> modify(final RoleSaveParam param);

    /**
     * 删除
     *
     * @param id 主键
     */
    Response<Long> delete(final Long id);

    /**
     * 查询角色的权限
     *
     * @param roleId 角色主键
     */
    Response<PermissionResponse> queryRolePermission(final Long roleId);

}
