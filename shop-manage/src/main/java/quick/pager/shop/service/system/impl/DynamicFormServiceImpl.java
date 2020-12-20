package quick.pager.shop.service.system.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.param.system.DynamicFormOtherSaveParam;
import quick.pager.shop.param.system.DynamicFormParam;
import quick.pager.shop.service.system.DynamicFormService;
import quick.pager.shop.platform.client.DynamicFormClient;
import quick.pager.shop.platform.request.DynamicFormSaveRequest;
import quick.pager.shop.platform.response.DynamicFormResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;

@Service
public class DynamicFormServiceImpl implements DynamicFormService {

    @Autowired
    private DynamicFormClient dynamicFormClient;

    @Override
    public Response<Long> create(DynamicFormOtherSaveParam param) {

        List<DynamicFormParam> widgets = param.getWidgets();
        String bizType = param.getBizType();

        Optional.ofNullable(widgets).orElse(Collections.emptyList()).forEach(item -> {
            DynamicFormSaveRequest request = new DynamicFormSaveRequest();

            BeanCopier.create(item, request).copy();
            request.setBizType(bizType);

            dynamicFormClient.create(request);
        });

        return Response.toResponse();
    }

    @Override
    public Response<Long> modify(DynamicFormOtherSaveParam param) {
        List<DynamicFormParam> widgets = param.getWidgets();
        String bizType = param.getBizType();

        Optional.ofNullable(widgets).orElse(Collections.emptyList()).forEach(item -> {
            DynamicFormSaveRequest request = new DynamicFormSaveRequest();

            BeanCopier.create(item, request).copy();
            request.setBizType(bizType);

            dynamicFormClient.modify(request);
        });

        return Response.toResponse();
    }

    @Override
    public Response<List<DynamicFormResponse>> get(String bizType) {

        return dynamicFormClient.get(bizType);
    }
}
