package quick.pager.shop.configuration;

import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.pager.shop.properties.QiniuProperties;

/**
 * 七牛云存储自动化配置
 *
 * @author siguiyang
 */
@Configuration
@ConditionalOnClass(Auth.class)
@EnableConfigurationProperties(QiniuProperties.class)
public class QiniuAutoConfiguration {

    @Autowired
    private QiniuProperties qiNiuProperties;

    @Bean
    public Auth auth() {
        return Auth.create(qiNiuProperties.getAccessKey(), qiNiuProperties.getSecretKey());
    }

    @Bean
    public com.qiniu.storage.Configuration configuration() {
        return new com.qiniu.storage.Configuration(Region.autoRegion());
    }

    @Bean
    public UploadManager uploadManager(com.qiniu.storage.Configuration configuration) {
        return new UploadManager(configuration);
    }
}
