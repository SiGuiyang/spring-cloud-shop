package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mapper.SMSTemplateMapper;
import quick.pager.shop.model.SMSTemplate;
import quick.pager.shop.platform.request.sms.SMSTemplatePageRequest;
import quick.pager.shop.platform.request.sms.SMSTemplateSaveRequest;
import quick.pager.shop.platform.response.SMSTemplateResponse;
import quick.pager.shop.service.SMSTemplateService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * SMSTemplateServiceImpl
 *
 * @author siguiyang
 */
@Service
public class SMSTemplateServiceImpl extends ServiceImpl<SMSTemplateMapper, SMSTemplate> implements SMSTemplateService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Response<Long> create(SMSTemplateSaveRequest request) {
        SMSTemplate smsTemplate = this.convert(request);
        smsTemplate.setDeleteStatus(Boolean.FALSE);
        smsTemplate.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(smsTemplate);

        redisTemplate.opsForValue().set("sms:template:code:" + smsTemplate.getTemplateCode(), smsTemplate, 24 * 30 * 60 * 60L);
        return Response.toResponse(smsTemplate.getId());
    }

    @Override
    public Response<Long> modify(SMSTemplateSaveRequest request) {
        SMSTemplate smsTemplate = this.convert(request);
        this.baseMapper.updateById(smsTemplate);
        redisTemplate.opsForValue().set("sms:template:code:" + smsTemplate.getTemplateCode(), smsTemplate, 24 * 30 * 60 * 60L);
        return Response.toResponse(smsTemplate.getId());
    }

    @Override
    public Response<List<SMSTemplateResponse>> queryPage(SMSTemplatePageRequest request) {
        SMSTemplate smsTemplate = new SMSTemplate();

        if (StringUtils.isNotBlank(request.getSmsTemplateCode())) {
            smsTemplate.setTemplateCode(request.getSmsTemplateCode());
        }
        Response<List<SMSTemplate>> page = this.toPage(request.getPage(), request.getPageSize(), new QueryWrapper<>(smsTemplate));

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()), page.getTotal());
    }

    @Override
    public Response<SMSTemplateResponse> sms(String templateCode) {

        SMSTemplateResponse response;
        SMSTemplate result = (SMSTemplate) redisTemplate.opsForValue().get("sms:template:code:" + templateCode);
        if (Objects.isNull(result)) {
            SMSTemplate smsTemplate = new SMSTemplate();
            smsTemplate.setTemplateCode(templateCode);
            SMSTemplate template = this.baseMapper.selectOne(new QueryWrapper<>(smsTemplate));
            if (Objects.isNull(template)) {
                return Response.toError(ResponseStatus.Code.FAIL_CODE, "未知短信渠道");
            }
            response = this.convert(template);
        } else {
            response = this.convert(result);
        }

        return Response.toResponse(response);
    }

    private SMSTemplate convert(SMSTemplateSaveRequest request) {
        return BeanCopier.copy(request, new SMSTemplate());
    }

    private SMSTemplateResponse convert(SMSTemplate template) {
        return BeanCopier.copy(template, new SMSTemplateResponse());
    }

}
