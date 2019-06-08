package quick.pager.shop.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.pager.shop.properties.XXLJobProperties;

/**
 * xxl job配置
 *
 * @author siguiyang
 */
@Configuration
@Slf4j
@EnableConfigurationProperties(XXLJobProperties.class)
public class JobConfig {

    @Autowired
    private XXLJobProperties xxlJobProperties;
    @Autowired
    private InetUtils inetUtils;


    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(xxlJobProperties.getAdminAddress());
        xxlJobSpringExecutor.setAppName(xxlJobProperties.getExecutor().getAppname());
        xxlJobSpringExecutor.setIp(inetUtils.findFirstNonLoopbackHostInfo().getIpAddress());
        xxlJobSpringExecutor.setPort(xxlJobProperties.getExecutor().getPort());
        xxlJobSpringExecutor.setAccessToken(xxlJobProperties.getAccessToken());
        xxlJobSpringExecutor.setLogPath(xxlJobProperties.getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(xxlJobProperties.getLogRetentionDays());

        return xxlJobSpringExecutor;
    }
}
