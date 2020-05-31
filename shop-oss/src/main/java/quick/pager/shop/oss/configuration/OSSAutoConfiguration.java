package quick.pager.shop.oss.configuration;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.pager.shop.oss.properties.OSSProperties;

/**
 * 阿里云OSS自动化配置
 *
 * @author siguiyang
 */
@Configuration
@ConditionalOnClass(OSSClient.class)
@EnableConfigurationProperties(OSSProperties.class)
public class OSSAutoConfiguration {

    @Autowired
    private OSSProperties ossProperties;

    @Bean
    public OSS ossClient() {
        return new OSSClientBuilder().build(ossProperties.getEndpoint(), ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret());
    }

}
