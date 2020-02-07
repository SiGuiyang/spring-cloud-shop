package quick.pager.shop.manage.service.system;

import java.util.List;
import quick.pager.shop.manage.param.system.SystemConfigParam;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.response.Response;

/**
 * 系统配置
 *
 * @author siguiyang
 * @version 3.0
 */
public interface SystemConfigService {

    /**
     * 配置列表
     */
    Response<List<SystemConfigResponse>> queryPage(SystemConfigParam param);

    /**
     * 配置列表
     */
    Response<List<SystemConfigResponse>> queryList(SystemConfigParam param);

    /**
     * 新增
     */
    Response<Long> create(SystemConfigParam param);

    /**
     * 修改
     */
    Response<Long> modify(SystemConfigParam param);

    /**
     * 删除
     *
     * @param id 主键
     */
    Response<Long> delete(Long id);
}
