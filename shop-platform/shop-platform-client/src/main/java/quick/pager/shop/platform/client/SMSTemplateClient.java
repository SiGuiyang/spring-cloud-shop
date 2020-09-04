package quick.pager.shop.platform.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.platform.fallback.SMSTemplateFallback;
import quick.pager.shop.platform.request.sms.SMSTemplatePageRequest;
import quick.pager.shop.platform.request.sms.SMSTemplateSaveRequest;
import quick.pager.shop.platform.response.SMSTemplateResponse;
import quick.pager.shop.user.response.Response;

/**
 * 短信模板对外开放接口
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.PLATFORM_CLIENT, path = ConstantsClient.PLATFORM, fallbackFactory = SMSTemplateFallback.class)
public interface SMSTemplateClient {

    /**
     * 创建
     *
     * @param request 请求参数
     * @return 短信模板主键
     */
    @PostMapping("/sms/create")
    Response<Long> create(@RequestBody SMSTemplateSaveRequest request);

    /**
     * 编辑
     *
     * @param request 请求参数
     * @return 短信模板主键
     */
    @PutMapping("/sms/modify")
    Response<Long> modify(@RequestBody SMSTemplateSaveRequest request);

    /**
     * 创建
     *
     * @param request 请求参数
     * @return 短信模板集
     */
    @GetMapping("/sms/page")
    Response<List<SMSTemplateResponse>> page(SMSTemplatePageRequest request);


    /**
     * 根据短信标识查询短信模板内容
     *
     * @param smsTemplateCode 短信标识码
     * @return 短信模板
     */
    @GetMapping("/sms/{smsTemplateCode}/info")
    Response<SMSTemplateResponse> sms(@PathVariable("smsTemplateCode") String smsTemplateCode);
}
