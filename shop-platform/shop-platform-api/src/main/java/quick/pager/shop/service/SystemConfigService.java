package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.SystemConfig;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.user.response.Response;

/**
 * 系统配置服务部
 *
 * @author siguiyang
 * @version 3.0
 */
public interface SystemConfigService {


    /**
     * 查看列表
     */
    List<SystemConfig> queryList(SystemConfigOtherRequest request);

    /**
     * 查看列表 分页
     */
    Response<List<SystemConfig>> queryPage(SystemConfigPageRequest request);

    /**
     * 新增
     */
    Response<Long> create(SystemConfigSaveRequest request);

    /**
     * 编辑
     */
    Response<Long> modify(SystemConfigSaveRequest request);

    /**
     * 更新定时任务缓存
     */
    void executeTask();
}
