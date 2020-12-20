package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import quick.pager.shop.platform.dto.SystemConfigDTO;
import quick.pager.shop.mapper.SystemConfigDetailMapper;
import quick.pager.shop.mapper.SystemConfigMapper;
import quick.pager.shop.model.SystemConfig;
import quick.pager.shop.model.SystemConfigDetail;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.service.SystemConfigService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 系统配置
 *
 * @author siguiyang
 */
@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {

    @Autowired
    private SystemConfigDetailMapper systemConfigDetailMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<SystemConfig> queryList(SystemConfigOtherRequest request) {
        LambdaQueryWrapper<SystemConfig> qw = this.toQueryWrapper(request.getConfigName(), request.getConfigType());
        qw.orderByDesc(SystemConfig::getUpdateTime);
        return this.baseMapper.selectList(qw);
    }

    @Override
    public Response<List<SystemConfig>> queryPage(SystemConfigPageRequest request) {

        LambdaQueryWrapper<SystemConfig> qw = this.toQueryWrapper(request.getConfigName(), request.getConfigType());
        qw.orderByDesc(SystemConfig::getUpdateTime);

        return this.toPage(request.getPage(), request.getPageSize(), qw);
    }

    @Override
    public Response<Long> create(SystemConfigSaveRequest request) {
        SystemConfig systemConfig = this.convert(request);
        systemConfig.setCreateTime(DateUtils.dateTime());
        systemConfig.setUpdateTime(DateUtils.dateTime());
        systemConfig.setDeleteStatus(Boolean.FALSE);
        systemConfig.setConfigStatus(Boolean.FALSE);
        this.baseMapper.insert(systemConfig);
        return Response.toResponse(systemConfig.getId());
    }

    @Override
    public Response<Long> modify(SystemConfigSaveRequest request) {
        SystemConfig systemConfig = this.convert(request);
        this.baseMapper.updateById(systemConfig);
        return Response.toResponse(systemConfig.getId());
    }

    @Override
    public void executeTask() {
        List<SystemConfig> systemConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<SystemConfig>().eq(SystemConfig::getConfigStatus, Boolean.FALSE));

        for (SystemConfig config : systemConfigs) {
            List<SystemConfigDetail> systemConfigDetails = systemConfigDetailMapper.selectList(new LambdaQueryWrapper<SystemConfigDetail>()
                    .eq(SystemConfigDetail::getConfigStatus, Boolean.FALSE)
                    .eq(SystemConfigDetail::getConfigKey, config.getConfigType()));

            redisTemplate.delete(config.getConfigType());
            systemConfigDetails.forEach(item -> {
                SystemConfigDTO dto = new SystemConfigDTO();
                dto.setConfigType(item.getConfigType());
                dto.setConfigValue(item.getConfigValue());
                dto.setConfigName(item.getConfigName());
                redisTemplate.opsForList().leftPush(config.getConfigType(), dto);
            });
        }

    }

    /**
     * 组织查询
     *
     * @param configName 配置项名称
     * @param configType 配置类型
     */
    private LambdaQueryWrapper<SystemConfig> toQueryWrapper(String configName, String configType) {
        LambdaQueryWrapper<SystemConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemConfig::getDeleteStatus, Boolean.FALSE);

        if (StringUtils.isNotBlank(configName)) {
            wrapper.likeRight(SystemConfig::getConfigName, configName);
        }
        if (StringUtils.isNotBlank(configType)) {
            wrapper.eq(SystemConfig::getConfigType, configType);
        }
        return wrapper;
    }

    /**
     * SystemConfigSaveRequest -> SystemConfig
     */
    private SystemConfig convert(SystemConfigSaveRequest request) {
        SystemConfig systemConfig = new SystemConfig();
        BeanCopier.create(request, systemConfig).copy();
        return systemConfig;
    }
}
