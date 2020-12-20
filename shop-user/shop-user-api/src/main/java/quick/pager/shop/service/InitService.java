package quick.pager.shop.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.RedisKeys;

/**
 * 项目初始化配置库入redis <br />
 *
 * @author siguiyang
 */
@Service
public class InitService {

//    @Autowired
//    private SystemConfigMapper systemConfigMapper;
//    @Autowired
//    private SmsTemplateMapper smsTemplateMapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void init() {
        initSystemConfig();

        initSMSTemplate();
    }


    /**
     * 初始化项目配置信息
     */
    private void initSystemConfig() {
//        List<SystemConfig> systemConfigs = systemConfigMapper.selectByModule(Constants.SMS_MODULE.USER);
//
//        systemConfigs.forEach(systemConfig -> {
//            redisService.set(RedisKeys.UserKeys.SHOP_SYSTEM_CONFIG + systemConfig.getConfigName(), systemConfig.getConfigValue(), 30 * 24 * 60 * 60);
//        });

    }

    /**
     * 初始化短信模板配置信息
     */
    private void initSMSTemplate() {

//        List<SmsTemplate> smsTemplates = smsTemplateMapper.selectByModule(Constants.SMS_MODULE.USER, null);
//        ArrayList<String> templateCodes = new ArrayList<>(smsTemplates.size());
//
//        smsTemplates.forEach(smsTemplate -> {
//            templateCodes.add(smsTemplate.getSmsTemplateCode());
//            redisService.set(RedisKeys.UserKeys.SHOP_SMS_TEMPLATE + smsTemplate.getSmsTemplateCode(), smsTemplate.getSmsTemplateContent(), 30 * 24 * 60 * 60);
//        });
//
//        redisService.setListOps(RedisKeys.UserKeys.SHOP_SMS_TEMPLATE_CODE, templateCodes);

    }
}
