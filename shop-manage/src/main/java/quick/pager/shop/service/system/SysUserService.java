package quick.pager.shop.service.system;

import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.SysUserDTO;
import quick.pager.shop.mapper.SysRoleMapper;
import quick.pager.shop.mapper.SysUserMapper;
import quick.pager.shop.model.SysRole;
import quick.pager.shop.model.SysUser;

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

    @Override
    public Response doService(BaseDTO dto) {

        SysUserDTO sysUserDTO = (SysUserDTO) dto;

        Response response;
        switch (sysUserDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifySysUser(sysUserDTO);
                break;
            case Constants.Event.LIST:
                response = querySysUser(sysUserDTO);
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);

        }
        return response;
    }

    /**
     * 用户列表
     */
    private Response querySysUser(SysUserDTO sysUserDTO) {

        PageHelper.startPage(sysUserDTO.getPage(), sysUserDTO.getPageSize());
        List<SysUser> sysUsers = sysUserMapper.selectSysUser(sysUserDTO.getSysName());

        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);

        Response<List<SysUser>> response = new Response<>();

        response.setData(pageInfo.getList());
        response.setTotal(pageInfo.getTotal());

        return response;
    }

    /**
     * 新增|修改
     */
    private Response modifySysUser(SysUserDTO sysUserDTO) {

        SysUser sysUser = new SysUser();

        BeanUtils.copyProperties(sysUserDTO, sysUser);
        if (Constants.Event.MODIFY.equals(sysUserDTO.getEvent())) {
            sysUserMapper.updateByPrimaryKeySelective(sysUser);
        } else {
            sysUser.setPassword(SecureUtil.md5(sysUser.getPassword()));
            sysUser.setCreateTime(new Date());
            sysUserMapper.insertSelective(sysUser);
        }

        // 是否更新sys_user 的roleCode 标志位 index[0] = 0 表示不更新 index[0] > 0 则表示更新
        final int[] index = {0};

        sysUserDTO.getRoleIds().forEach(id -> {
            SysRole sysRole = sysRoleMapper.selectSysRole(id, sysUser.getId());
            // 如果没有用户角色，则新增
            if (ObjectUtils.isEmpty(sysRole)) {
                sysRole = new SysRole();
                sysRole.setRoleId(id);
                sysRole.setSysUserId(sysUser.getId());
                sysRole.setCreateTime(new Date());
                sysRole.setDeleteStatus(false);
                sysRoleMapper.insertSelective(sysRole);
                index[0]++;
            }

        });

        // 更新角色代码
        if (0 != index[0]) {
            sysUserMapper.updateByPrimaryKeySelective(sysUser);
        }

        return new Response();
    }
}
