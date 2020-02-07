package quick.pager.shop.manage.service.system;

import java.util.List;
import quick.pager.shop.manage.param.system.SysUserPageParam;
import quick.pager.shop.manage.param.system.SysUserParam;
import quick.pager.shop.manage.response.system.SysUserResponse;
import quick.pager.shop.response.Response;

/**
 * 系统用户服务
 *
 * @author siguiyang
 * @version 3.0
 */
public interface SysUserService {

    /**
     * 查询系统用户列表
     */
    Response<List<SysUserResponse>> queryPage(SysUserPageParam param);

    /**
     * 创建用户
     */
    Response<Long> create(SysUserParam param);

    /**
     * 修改用户
     */
    Response<Long> modify(SysUserParam param);

    /**
     * 用户登陆权限信息
     *
     * @param phone 手机号码
     */
    Response adminInfo(String phone);
}
