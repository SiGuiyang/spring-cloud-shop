package quick.pager.shop.platform.service;

import java.util.List;
import quick.pager.shop.platform.model.SMSTemplate;
import quick.pager.shop.platform.request.sms.SMSTemplatePageRequest;
import quick.pager.shop.platform.request.sms.SMSTemplateSaveRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;

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
    Long create(SMSTemplateSaveRequest request);

    /**
     * 更新
     *
     * @param request 请求参数
     * @return 短信模板主键
     */
    Long modify(SMSTemplateSaveRequest request);

    /**
     * 列表 分页
     *
     * @param request 请求参数
     * @return 短信模板集
     */
    Response<List<SMSTemplate>> queryPage(SMSTemplatePageRequest request);

    /**
     * 根据短信标识查询短信模板内容
     *
     * @param smsTemplateCode 短信标识码
     * @return 短信模板
     */
    SMSTemplate sms(String smsTemplateCode);
}
