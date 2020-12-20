package quick.pager.shop.service.system.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.service.system.SystemConfigService;
import quick.pager.shop.param.system.SystemConfigParam;
import quick.pager.shop.platform.client.SystemConfigClient;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    @Autowired
    private SystemConfigClient systemConfigClient;

    @Override
    public Response<List<SystemConfigResponse>> queryPage(final SystemConfigParam param) {

        SystemConfigPageRequest request = new SystemConfigPageRequest();
        BeanCopier.create(param, request).copy();

        return systemConfigClient.queryPage(request);

    }

    @Override
    public Response<List<SystemConfigResponse>> queryList(final SystemConfigParam param) {
        SystemConfigOtherRequest request = new SystemConfigOtherRequest();
        BeanCopier.create(param, request).copy();
        return systemConfigClient.queryList(request);
    }

    @Override
    public Response<Long> create(final SystemConfigParam param) {

        SystemConfigSaveRequest request = new SystemConfigSaveRequest();
        BeanCopier.create(param, request).copy();

        return systemConfigClient.create(request);
    }

    @Override
    public Response<Long> modify(final SystemConfigParam param) {
        SystemConfigSaveRequest request = new SystemConfigSaveRequest();
        BeanCopier.create(param, request).copy();

        return systemConfigClient.modify(request);
    }

    @Override
    public Response<Long> delete(final Long id) {
        SystemConfigSaveRequest request = new SystemConfigSaveRequest();
        request.setId(id);
        request.setDeleteStatus(Boolean.TRUE);
        return systemConfigClient.modify(request);
    }
}
