package quick.pager.shop.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import quick.pager.shop.service.SystemConfigService;

/**
 * 定时更新配置缓存
 *
 * @author siguiyang
 */
@Component
@EnableScheduling
public class RedisCacheTask {
    @Autowired
    private SystemConfigService systemConfigService;

    /**
     * 每天凌晨更新缓存
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void execute() {
        systemConfigService.executeTask();
    }
}
