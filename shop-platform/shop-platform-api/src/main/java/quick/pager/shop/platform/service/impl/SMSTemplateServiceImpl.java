package quick.pager.shop.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import quick.pager.shop.platform.mapper.SMSTemplateMapper;
import quick.pager.shop.platform.model.SMSTemplate;
import quick.pager.shop.platform.request.sms.SMSTemplatePageRequest;
import quick.pager.shop.platform.request.sms.SMSTemplateSaveRequest;
import quick.pager.shop.platform.service.SMSTemplateService;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * SMSTemplateServiceImpl
 *
 * @author siguiyang
 */
@Service
public class SMSTemplateServiceImpl extends ServiceImpl<SMSTemplateMapper, SMSTemplate> implements SMSTemplateService {

    @Override
    public Long create(SMSTemplateSaveRequest request) {
        SMSTemplate smsTemplate = this.convert(request);
        smsTemplate.setDeleteStatus(Boolean.FALSE);
        smsTemplate.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(smsTemplate);
        return smsTemplate.getId();
    }

    @Override
    public Long modify(SMSTemplateSaveRequest request) {
        SMSTemplate smsTemplate = this.convert(request);
        this.baseMapper.updateById(smsTemplate);
        return smsTemplate.getId();
    }

    @Override
    public Response<List<SMSTemplate>> queryPage(SMSTemplatePageRequest request) {
        SMSTemplate smsTemplate = new SMSTemplate();
        if (StringUtils.isNotBlank(request.getModule())) {
            smsTemplate.setModule(request.getModule());
        }

        if (StringUtils.isNotBlank(request.getSmsTemplateCode())) {
            smsTemplate.setSmsTemplateCode(request.getSmsTemplateCode());
        }
        return this.toPage(request.getPage(), request.getPageSize(), new QueryWrapper<>(smsTemplate));
    }

    @Override
    public SMSTemplate sms(String smsTemplateCode) {
        SMSTemplate smsTemplate = new SMSTemplate();
        smsTemplate.setSmsTemplateCode(smsTemplateCode);
        return this.baseMapper.selectOne(new QueryWrapper<>(smsTemplate));
    }


    private SMSTemplate convert(SMSTemplateSaveRequest request) {
        return BeanCopier.create(request, new SMSTemplate()).copy();
    }

}
