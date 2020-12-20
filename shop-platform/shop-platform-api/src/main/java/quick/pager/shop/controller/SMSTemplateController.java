package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.platform.request.sms.SMSTemplatePageRequest;
import quick.pager.shop.platform.request.sms.SMSTemplateSaveRequest;
import quick.pager.shop.platform.response.SMSTemplateResponse;
import quick.pager.shop.service.SMSTemplateService;
import quick.pager.shop.user.response.Response;

/**
 * 短信模板
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.PLATFORM)
public class SMSTemplateController {

    @Autowired
    private SMSTemplateService smsTemplateService;

    /**
     * 创建
     *
     * @param request 请求参数
     * @return 短信模板主键
     */
    @PostMapping("/sms/create")
    public Response<Long> create(@RequestBody SMSTemplateSaveRequest request) {
        return smsTemplateService.create(request);
    }

    /**
     * 编辑
     *
     * @param request 请求参数
     * @return 短信模板主键
     */
    @PutMapping("/sms/modify")
    public Response<Long> modify(@RequestBody SMSTemplateSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return smsTemplateService.modify(request);
    }

    /**
     * 列表 分页
     *
     * @param request 请求参数
     * @return 短信模板集
     */
    @GetMapping("/sms/page")
    public Response<List<SMSTemplateResponse>> page(SMSTemplatePageRequest request) {
        return smsTemplateService.queryPage(request);
    }


    /**
     * 根据短信标识查询短信模板内容
     *
     * @param smsTemplateCode 短信标识码
     * @return 短信模板
     */
    @GetMapping("/sms/{smsTemplateCode}/info")
    public Response<SMSTemplateResponse> sms(@PathVariable("smsTemplateCode") String smsTemplateCode) {
        return smsTemplateService.sms(smsTemplateCode);
    }

}
