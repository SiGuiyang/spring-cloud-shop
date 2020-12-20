package quick.pager.shop.service.system;

import java.util.List;
import quick.pager.shop.param.system.SysUserOtherParam;
import quick.pager.shop.param.system.SysUserPageParam;
import quick.pager.shop.param.system.SysUserSaveParam;
import quick.pager.shop.response.system.SysUserDownloadResponse;
import quick.pager.shop.response.system.SysUserResponse;
import quick.pager.shop.user.response.Response;

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
     * 查询系统用户列表
     *
     * @param param 查询参数
     * @return 数据列表
     */
    Response<List<SysUserResponse>> queryList(SysUserOtherParam param);

    /**
     * 获取导出文件的数据集
     *
     * @param ids 用户主键集
     */
    List<SysUserDownloadResponse> queryDownload(final List<Long> ids);

    /**
     * 创建用户
     */
    Response<Long> create(SysUserSaveParam param);

    /**
     * 修改用户
     */
    Response<Long> modify(SysUserSaveParam param);

    /**
     * 用户登陆权限信息
     *
     * @param phone 手机号码
     */
    Response adminInfo(String phone);
}
