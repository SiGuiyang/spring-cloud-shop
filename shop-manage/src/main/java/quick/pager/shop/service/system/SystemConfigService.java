package quick.pager.shop.service.system;

import java.util.List;
import quick.pager.shop.param.system.SystemConfigParam;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.user.response.Response;

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
    Response<List<SystemConfigResponse>> queryPage(final SystemConfigParam param);

    /**
     * 配置列表
     */
    Response<List<SystemConfigResponse>> queryList(final SystemConfigParam param);

    /**
     * 新增
     */
    Response<Long> create(final SystemConfigParam param);

    /**
     * 修改
     */
    Response<Long> modify(final SystemConfigParam param);

    /**
     * 删除
     *
     * @param id 主键
     */
    Response<Long> delete(final Long id);
}
