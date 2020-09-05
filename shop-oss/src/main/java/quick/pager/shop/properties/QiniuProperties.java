package quick.pager.shop.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 七牛配置参数
 *
 * @author siguiyang
 * @version 3.0
 */
@ConfigurationProperties(value = "qiniu")
@Data
public class QiniuProperties {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String endpoint;
}
