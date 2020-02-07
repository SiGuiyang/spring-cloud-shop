package quick.pager.shop.platform.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import quick.pager.shop.platform.service.SystemConfigService;

/**
 * 初始化系统配置参数加入到redis缓存中
 *
 * @author siguiyang
 * @version 3.0
 */
@Component
public class PlatformRunner implements CommandLineRunner {

    @Autowired
    private SystemConfigService systemConfigService;

    @Override
    public void run(String... args) throws Exception {
        systemConfigService.executeTask();
    }
}
