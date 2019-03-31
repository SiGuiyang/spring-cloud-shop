package quick.pager.shop.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.RoleDTO;
import quick.pager.shop.mapper.RoleMapper;
import quick.pager.shop.mapper.RolePermissionMapper;
import quick.pager.shop.model.Role;
import quick.pager.shop.model.RolePermission;

/**
 * 角色
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class RoleService implements IService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public Response doService(BaseDTO dto) {
        RoleDTO roleDTO = (RoleDTO) dto;
        Response response = null;
        switch (roleDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifyRole(roleDTO);
                break;
            case Constants.Event.LIST:
                response = selectRoles(roleDTO);
                break;
            case "classification":
                response = getRoleClassification();
                break;
            case "rolePermission": // 查看某个角色的权限
                response = getRolePermission(roleDTO);
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return response;
    }

    /**
     * 查看某个角色的权限
     */
    private Response<List<Long>> getRolePermission(RoleDTO roleDTO) {
        List<RolePermission> permissions = rolePermissionMapper.selectPermissions(roleDTO.getId());
        List<Long> ids = Lists.newArrayList();
        permissions.forEach(permission -> ids.add(permission.getPermissionId()));
        return new Response<>(ids);
    }

    // 角色分类
    private Response getRoleClassification() {
        List<Role> roles = roleMapper.selectRoles(null, Boolean.FALSE);
        Response<List<Role>> response = new Response<>();
        response.setData(roles);
        return response;
    }

    // 角色列表
    private Response selectRoles(RoleDTO roleDTO) {
        PageHelper.startPage(roleDTO.getPage(), roleDTO.getPageSize());
        List<Role> roles = roleMapper.selectRoles(roleDTO.getRoleName(), null);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);

        Response<List<Role>> response = new Response<>();
        response.setData(pageInfo.getList());
        response.setTotal(pageInfo.getTotal());

        return response;
    }

    // 新增修改角色
    private Response modifyRole(RoleDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        if (Constants.Event.ADD.equals(dto.getEvent())) { // 新增
            role.setDeleteStatus(false);
            role.setCreateTime(new Date());
            roleMapper.insertSelective(role);
        } else {
            roleMapper.updateByPrimaryKeySelective(role);
        }
        return new Response();
    }
}
