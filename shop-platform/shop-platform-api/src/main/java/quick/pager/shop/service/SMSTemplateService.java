package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.SMSTemplate;
import quick.pager.shop.platform.request.sms.SMSTemplatePageRequest;
import quick.pager.shop.platform.request.sms.SMSTemplateSaveRequest;
import quick.pager.shop.platform.response.SMSTemplateResponse;
import quick.pager.shop.user.response.Response;

/**
 * 短信模板服务
 *
 * @author siguiyang
 */
public interface SMSTemplateService extends IService<SMSTemplate> {

    /**
     * 创建
     *
     * @param request 请求参数
     * @return 短信模板主键
     */
    Response<Long> create(SMSTemplateSaveRequest request);

    /**
     * 更新
     *
     * @param request 请求参数
     * @return 短信模板主键
     */
    Response<Long> modify(SMSTemplateSaveRequest request);

    /**
     * 列表 分页
     *
     * @param request 请求参数
     * @return 短信模板集
     */
    Response<List<SMSTemplateResponse>> queryPage(SMSTemplatePageRequest request);

    /**
     * 根据短信标识查询短信模板内容
     *
     * @param templateCode 短信标识码
     * @return 短信模板
     */
    Response<SMSTemplateResponse> sms(String templateCode);
}
