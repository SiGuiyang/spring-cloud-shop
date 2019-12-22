package quick.pager.shop.platform.controller;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.platform.model.DynamicForm;
import quick.pager.shop.platform.request.DynamicFormSaveRequest;
import quick.pager.shop.platform.response.DynamicFormResponse;
import quick.pager.shop.platform.service.DynamicFormService;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.BeanCopier;

/**
 * <p>
 * 自定义表单
 * </p>
 *
 * @author siguiyang
 * @since 2019-12-14
 */
@Controller
@RequestMapping(ConstantsClient.PLATFORM)
public class DynamicFormController {

    @Autowired
    private DynamicFormService dynamicFormService;

    /**
     * 新增
     */
    @PostMapping("/dynamic/form/create")
    public Response<Long> create(@RequestBody DynamicFormSaveRequest request) {
        DynamicForm df = new DynamicForm();
        BeanCopier.create(request, df).copy();
        dynamicFormService.save(df);
        return new Response<>(df.getId());
    }

    /**
     * 修改
     */
    @PostMapping("/dynamic/form/modify")
    public Response<Long> modify(@RequestBody DynamicFormSaveRequest request) {

        DynamicForm df = new DynamicForm();
        BeanCopier.create(request, df).copy();
        dynamicFormService.updateById(df);
        return new Response<>(df.getId());
    }

    /**
     * 根据bizType 获取表单模型
     */
    @GetMapping("/dynamic/form/get")
    public Response<List<DynamicFormResponse>> get(@RequestParam String bizType) {

        List<DynamicForm> forms = dynamicFormService.get(bizType);
        return new Response<>(Optional.ofNullable(forms).orElse(Collections.emptyList()).stream().map(this::convert).collect(Collectors.toList()));
    }

    /**
     * 数据转换
     * DynamicForm -> DynamicFormResponse
     */
    private DynamicFormResponse convert(DynamicForm df) {
        DynamicFormResponse response = new DynamicFormResponse();
        BeanCopier.create(df, response).copy();
        return response;
    }

}
