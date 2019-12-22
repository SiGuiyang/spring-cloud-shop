package quick.pager.shop.manage.init;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.SysConfigKeys;
import quick.pager.shop.manage.utils.SystemConfigMap;
import quick.pager.shop.platform.client.SystemConfigClient;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.utils.SysConfigMap;

/**
 * 管理中心配置初始化
 *
 * @author siguiyang
 * @version 3.0
 */
@Component
@Slf4j
public class ManageInit implements CommandLineRunner {

    @Value("${qiniu.access_key}")
    private String qiniuAccessKey;
    @Value("${qiniu.secret_key}")
    private String qiniuSecretKey;
    @Value("${qiniu.bucket}")
    private String qiniuBucket;

    @Autowired
    private SystemConfigClient systemConfigClient;
    @Autowired
    private RedisService redisService;

    @Override
    public void run(String... args) throws Exception {

        init();
    }

    private void init() {

        log.info("开始加载JVM缓存。。。");
        initQiniu();
        initConfig();
        log.info("加载JVM缓存结束。。。");
    }

    private void initQiniu() {
        log.info("初始化七牛配置");
        SysConfigMap.put(SysConfigKeys.QINIU_ACCESS_KEY, qiniuAccessKey);
        SysConfigMap.put(SysConfigKeys.QINIU_SECRET_KEY, qiniuSecretKey);
        SysConfigMap.put(SysConfigKeys.QINIU_BUCKET, qiniuBucket);

    }

    private void initConfig() {
        log.info("初始化系统配置");
        SystemConfigOtherRequest request = new SystemConfigOtherRequest();
        Response<List<SystemConfigResponse>> response = systemConfigClient.queryList(request);
        SystemConfigMap.putAllSystemConfig(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                .collect(Collectors.groupingBy(SystemConfigResponse::getConfigType)));
    }
}
