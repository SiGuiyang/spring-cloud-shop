package quick.pager.shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.SysConfigKeys;
import quick.pager.shop.mapper.SystemConfigMapper;
import quick.pager.shop.model.SystemConfig;
import quick.pager.shop.utils.SysConfigMap;
import quick.pager.shop.utils.SystemConfigMap;

@Service
@Slf4j
public class InitService {

    @Value("${qiniu.access_key}")
    private String qiniuAccessKey;
    @Value("${qiniu.secret_key}")
    private String qiniuSecretKey;
    @Value("${qiniu.bucket}")
    private String qiniuBucket;

    @Autowired
    private SystemConfigMapper systemConfigMapper;
    @Autowired
    private RedisService redisService;


    @PostConstruct
    public void init() {

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
        SystemConfig systemConfig = new SystemConfig();
        systemConfig.setDeleteStatus(Boolean.FALSE);
        // 查询所有的系统配置
        List<SystemConfig> systemConfigs = systemConfigMapper.selectList(new QueryWrapper<>(systemConfig));

        Map<String, List<SystemConfig>> map = systemConfigs.stream().collect(Collectors.groupingBy(SystemConfig::getConfigType));
        SystemConfigMap.putAllSystemConfig(map);
    }
}
