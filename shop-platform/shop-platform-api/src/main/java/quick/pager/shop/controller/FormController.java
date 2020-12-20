package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.platform.request.form.FormOtherRequest;
import quick.pager.shop.platform.request.form.FormPageRequest;
import quick.pager.shop.platform.request.form.FormSaveRequest;
import quick.pager.shop.platform.response.FieldResponse;
import quick.pager.shop.platform.response.FormResponse;
import quick.pager.shop.service.FieldService;
import quick.pager.shop.service.FormService;
import quick.pager.shop.user.response.Response;

/**
 * 表单模型
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.PLATFORM)
public class FormController {

    @Autowired
    private FormService formService;
    @Autowired
    private FieldService fieldService;

    /**
     * 创建
     */
    @PostMapping("/dynamic/form/create")
    public Response<Long> create(@RequestBody FormSaveRequest request) {
        if (check(null, request.getBizType())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "已存在相同表单模型");
        }
        return formService.create(request);
    }

    /**
     * 创建
     */
    @PutMapping("/dynamic/form/modify")
    public Response<Long> modify(@RequestBody FormSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        if (check(request.getId(), request.getBizType())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "已存在相同表单模型");
        }
        return formService.modify(request);
    }

    /**
     * 创建
     */
    @PostMapping("/dynamic/form/page")
    public Response<List<FormResponse>> modify(@RequestBody FormPageRequest request) {

        return formService.queryPage(request);
    }

    /**
     * 根据bizType 获取表单模型
     */
    @GetMapping("/dynamic/form/get")
    public Response<List<FieldResponse>> get(@RequestParam String bizType) {
        return Response.toResponse(formService.get(bizType));
    }

    /**
     * 验证bizType 唯一性
     *
     * @param id      表单主键
     * @param bizType 表单模型
     *                ¬
     */
    private boolean check(Long id, String bizType) {
        FormOtherRequest request = new FormOtherRequest();
        request.setBizType(bizType);
        Response<List<FormResponse>> list = formService.queryList(request);
        return list.getData().stream()
                .filter(item -> Objects.isNull(id) || item.getId().compareTo(id) != 0)
                .anyMatch(item -> item.getBizType().equals(bizType));
    }

}

