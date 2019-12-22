package quick.pager.shop.platform.service;

import java.util.List;
import quick.pager.shop.platform.model.SystemConfig;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IPageService;

/**
 * 系统配置服务部
 *
 * @author siguiyang
 * @version 3.0
 */
public interface SystemConfigService extends IPageService<SystemConfig> {


    /**
     * 查看列表
     */
    List<SystemConfig> queryList(SystemConfigOtherRequest request);

    /**
     * 查看列表 分页
     */
    Response<List<SystemConfig>> queryPage(SystemConfigPageRequest request);
}
