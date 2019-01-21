package quick.pager.shop.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.service.RedisService;
import quick.pager.shop.model.common.SmsTemplate;
import quick.pager.shop.model.common.SystemConfig;
import quick.pager.shop.user.mapper.SmsTemplateMapper;
import quick.pager.shop.user.mapper.SystemConfigMapper;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 项目初始化配置库入redis <br />
 *
 * @author siguiyang
 */
@Service
public class InitService {

    @Autowired
    private SystemConfigMapper systemConfigMapper;
    @Autowired
    private SmsTemplateMapper smsTemplateMapper;
    @Autowired
    private RedisService redisService;

    @PostConstruct
    public void init() {
        initSystemConfig();

        initSMSTemplate();
    }


    /**
     * 初始化项目配置信息
     */
    private void initSystemConfig() {
        List<SystemConfig> systemConfigs = systemConfigMapper.selectByModule(Constants.Module.USER);

        systemConfigs.forEach(systemConfig -> {
            redisService.set(RedisKeys.UserKeys.SHOP_SYSTEM_CONFIG + systemConfig.getConfigName(), systemConfig.getConfigValue(), 30 * 24 * 60 * 60);
        });

    }

    /**
     * 初始化短信模板配置信息
     */
    private void initSMSTemplate() {

        List<SmsTemplate> smsTemplates = smsTemplateMapper.selectByModule(Constants.Module.USER, null);
        smsTemplates.forEach(smsTemplate -> {
            redisService.set(RedisKeys.UserKeys.SHOP_SMS_TEMPLATE + smsTemplate.getSmsTemplateCode(), smsTemplate.getSmsTemplateContent(), 30 * 24 * 60 * 60);
        });

    }
}
