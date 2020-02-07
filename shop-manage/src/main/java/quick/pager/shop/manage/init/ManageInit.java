package quick.pager.shop.manage.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.SysConfigKeys;
import quick.pager.shop.properties.QiniuProperties;
import quick.pager.shop.utils.SysConfigMap;

/**
 * 管理中心配置初始化
 *
 * @author siguiyang
 * @version 3.0
 */
@Component
@Slf4j
@EnableConfigurationProperties(QiniuProperties.class)
public class ManageInit implements CommandLineRunner {

    @Autowired
    private QiniuProperties qiniu;

    @Override
    public void run(String... args) throws Exception {

        init();
    }

    private void init() {

        log.info("开始加载JVM缓存。。。");
        initQiniu();
        log.info("加载JVM缓存结束。。。");
    }

    private void initQiniu() {
        log.info("初始化七牛配置");
        SysConfigMap.put(SysConfigKeys.QINIU_ACCESS_KEY, qiniu.getAccessKey());
        SysConfigMap.put(SysConfigKeys.QINIU_SECRET_KEY, qiniu.getSecretKey());
        SysConfigMap.put(SysConfigKeys.QINIU_BUCKET, qiniu.getBucket());

    }
}
