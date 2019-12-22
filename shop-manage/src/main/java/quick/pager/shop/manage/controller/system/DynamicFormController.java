package quick.pager.shop.manage.controller.system;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.manage.param.system.DynamicFormOtherSaveParam;
import quick.pager.shop.manage.service.system.DynamicFormService;
import quick.pager.shop.platform.response.DynamicFormResponse;
import quick.pager.shop.response.Response;

/**
 * 自定义表单
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.MANAGE)
public class DynamicFormController {

    @Autowired
    private DynamicFormService dynamicFormService;

    /**
     * 创建表单
     */
    @PostMapping("/dynamic/form/create")
    public Response<Long> create(@RequestBody DynamicFormOtherSaveParam param) {

        if (StringUtils.isBlank(param.getBizType())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return dynamicFormService.create(param);
    }

    /**
     * 创建表单
     */
    @PostMapping("/dynamic/form/modify")
    public Response modify(@RequestBody DynamicFormOtherSaveParam param) {

        if (StringUtils.isBlank(param.getBizType())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return dynamicFormService.modify(param);
    }

    /**
     * 创建表单
     */
    @PostMapping("/dynamic/form/get")
    public Response<List<DynamicFormResponse>> get(@RequestParam String bizType) {

        return dynamicFormService.get(bizType);
    }


}
