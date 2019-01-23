package quick.pager.shop.manage;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import quick.pager.common.constants.SysConfigKeys;
import quick.pager.common.utils.SysConfigMap;

/**
 * @author siguiyang
 */
@SpringBootApplication(scanBasePackages = {"quick.pager.common", "quick.pager.shop.manage", "com.codingapi.txlcn.logger"})
@MapperScan(basePackages = "quick.pager.shop.manage.mapper")
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@Slf4j
public class ManageApplication implements CommandLineRunner, WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }

    @Value("${qiniu.access_key}")
    private String qiniuAccessKey;
    @Value("${qiniu.secret_key}")
    private String qiniuSecretKey;
    @Value("${qiniu.bucket}")
    private String qiniuBucket;


    @Override
    public void run(String... args) throws Exception {
        log.info("开始加载JVM缓存。。。");

        SysConfigMap.put(SysConfigKeys.QINIU_ACCESS_KEY, qiniuAccessKey);
        SysConfigMap.put(SysConfigKeys.QINIU_SECRET_KEY, qiniuSecretKey);
        SysConfigMap.put(SysConfigKeys.QINIU_BUCKET, qiniuBucket);

        log.info("加载JVM缓存结束。。。");
    }

}
