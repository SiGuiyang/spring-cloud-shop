package quick.pager.shop.manage.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.constants.Constants;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.manage.dto.RoleDTO;
import quick.pager.shop.manage.mapper.RoleMapper;
import quick.pager.shop.model.manage.Role;

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

    @Override
    public Response doService(DTO dto) {
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
        }
        return response;
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
            role.setCreateTime(new Date());
            roleMapper.insertSelective(role);
        } else {
            roleMapper.updateByPrimaryKeySelective(role);
        }
        return new Response();
    }
}
