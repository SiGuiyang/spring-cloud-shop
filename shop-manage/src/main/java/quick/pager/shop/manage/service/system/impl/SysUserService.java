package quick.pager.shop.manage.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.manage.mapper.RoleMapper;
import quick.pager.shop.manage.model.Role;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.manage.param.system.SysUserParam;
import quick.pager.shop.manage.mapper.SysRoleMapper;
import quick.pager.shop.manage.mapper.SysUserMapper;
import quick.pager.shop.manage.model.SysRole;
import quick.pager.shop.manage.model.SysUser;
import quick.pager.shop.utils.DateUtils;
import quick.pager.shop.manage.utils.PrincipalUtils;

/**
 * 系统用户服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class SysUserService implements IService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Response doService(BaseDTO dto) {

        SysUserParam sysUserParam = (SysUserParam) dto;

        Response response;
        switch (sysUserParam.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifySysUser(sysUserParam);
                break;
            case Constants.Event.LIST:
                response = querySysUser(sysUserParam);
                break;
            case "status":
                response = modifyStatusSysUser(sysUserParam.getId(), sysUserParam.getDeleteStatus());
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);

        }
        return response;
    }

    private Response modifyStatusSysUser(Long id, Boolean deleteStatus) {

        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setDeleteStatus(deleteStatus);
        sysUser.setUpdateTime(DateUtils.dateTime());
        sysUser.setUpdateUser(PrincipalUtils.getPrincipal().getName());
        sysUserMapper.updateById(sysUser);
        return new Response();
    }

    /**
     * 用户列表
     */
    private Response querySysUser(SysUserParam sysUserParam) {

        Page<SysUser> page = new Page<>(sysUserParam.getPage(), sysUserParam.getPageSize());

        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        if (!StringUtils.isEmpty(sysUserParam.getPhone())) {
            qw.eq("phone", sysUserParam.getPhone());
        }

        IPage<SysUser> sysUserIPage = sysUserMapper.selectPage(page, qw);

        Response<List<SysUser>> response = new Response<>();

        sysUserIPage.getRecords().forEach(sysUser -> {
            List<SysRole> sysRoles = sysRoleMapper.selectBySysUserId(sysUser.getId());
            sysRoles.forEach(sysRole -> {
                Role role = roleMapper.selectById(sysRole.getRoleId());
                sysUser.getRoles().add(role);
                sysUser.getRoleIds().add(role.getId());
            });
        });

        response.setData(sysUserIPage.getRecords());
        response.setTotal(sysUserIPage.getTotal());

        return response;
    }

    /**
     * 新增|修改
     */
    private Response modifySysUser(SysUserParam sysUserParam) {

        SysUser sysUser = new SysUser();

        BeanUtils.copyProperties(sysUserParam, sysUser);
        if (Constants.Event.MODIFY.equals(sysUserParam.getEvent())) {
            sysUserMapper.updateById(sysUser);
        } else {
            sysUser.setCreateUser(PrincipalUtils.getPrincipal().getName());
            sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
            sysUser.setCreateTime(DateUtils.dateTime());
            sysUser.setDeleteStatus(false);
            sysUserMapper.insert(sysUser);
        }

        // 是否更新sys_user 的roleCode 标志位 index[0] = 0 表示不更新 index[0] > 0 则表示更新
        final int[] index = {0};

        sysUserParam.getRoleIds().forEach(id -> {
            SysRole sysRole = sysRoleMapper.selectSysRole(id, sysUser.getId());
            // 如果没有用户角色，则新增
            if (ObjectUtils.isEmpty(sysRole)) {
                sysRole = new SysRole();
                sysRole.setRoleId(id);
                sysRole.setSysUserId(sysUser.getId());
                sysRole.setCreateTime(DateUtils.dateTime());
                sysRole.setDeleteStatus(false);
                sysRoleMapper.insert(sysRole);
                index[0]++;
            }

        });

        // 更新角色代码
        if (0 != index[0]) {
            sysUserMapper.updateById(sysUser);
        }

        return new Response();
    }
}
