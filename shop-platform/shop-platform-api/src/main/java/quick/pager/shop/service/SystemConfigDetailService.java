package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.SystemConfigDetail;
import quick.pager.shop.platform.request.SystemConfigDetailOtherRequest;
import quick.pager.shop.platform.request.SystemConfigDetailSaveRequest;
import quick.pager.shop.platform.response.SystemConfigDetailResponse;
import quick.pager.shop.user.response.Response;

/**
 * 系统配置服务部
 *
 * @author siguiyang
 * @version 3.0
 */
public interface SystemConfigDetailService extends IService<SystemConfigDetail> {


    /**
     * 查看列表
     */
    Response<List<SystemConfigDetailResponse>> queryList(SystemConfigDetailOtherRequest request);

    /**
     * 新增
     */
    Response<Long> create(SystemConfigDetailSaveRequest request);

    /**
     * 编辑
     */
    Response<Long> modify(SystemConfigDetailSaveRequest request);
}
