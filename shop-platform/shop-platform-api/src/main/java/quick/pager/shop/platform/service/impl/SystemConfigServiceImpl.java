package quick.pager.shop.platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.platform.dto.SystemConfigDTO;
import quick.pager.shop.platform.mapper.SystemConfigMapper;
import quick.pager.shop.platform.model.SystemConfig;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.platform.service.SystemConfigService;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {

    @Autowired
    private RedisService redisService;

    @Override
    public List<SystemConfig> queryList(SystemConfigOtherRequest request) {
        QueryWrapper<SystemConfig> qw = this.toQueryWrapper(request.getConfigName(), request.getConfigType(), request.getModule());

        return this.baseMapper.selectList(qw);
    }

    @Override
    public Response<List<SystemConfig>> queryPage(SystemConfigPageRequest request) {

        QueryWrapper<SystemConfig> qw = this.toQueryWrapper(request.getConfigName(), request.getConfigType(), request.getModule());

        return this.toPage(request.getPage(), request.getPageSize(), qw);
    }

    @Override
    public Response<Long> create(SystemConfigSaveRequest request) {
        SystemConfig systemConfig = this.convert(request);
        systemConfig.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(systemConfig);
        return new Response<>(systemConfig.getId());
    }

    @Override
    public Response<Long> modify(SystemConfigSaveRequest request) {
        SystemConfig systemConfig = this.convert(request);
        this.baseMapper.updateById(systemConfig);
        return new Response<>(systemConfig.getId());
    }

    @Override
    public void executeTask() {
        SystemConfig systemConfig = new SystemConfig();
        systemConfig.setDeleteStatus(Boolean.FALSE);
        List<SystemConfig> systemConfigs = this.baseMapper.selectList(new QueryWrapper<>(systemConfig));
        Map<String, List<SystemConfigDTO>> listMap = systemConfigs.stream().map(item -> {
            SystemConfigDTO dto = new SystemConfigDTO();
            dto.setConfigType(item.getConfigType());
            dto.setConfigName(item.getConfigName());
            dto.setConfigValue(item.getConfigValue());
            dto.setDescription(item.getDescription());
            return dto;
        }).collect(Collectors.groupingBy(SystemConfigDTO::getConfigType, Collectors.toList()));
        listMap.forEach((k, v) -> redisService.set(k, JSON.toJSONString(v), 24 * 60 * 60L * 2));
    }

    /**
     * 组织查询
     *
     * @param configName 配置项名称
     * @param configType 配置类型
     * @param module     配置所属模块
     */
    private QueryWrapper<SystemConfig> toQueryWrapper(String configName, String configType, String module) {
        SystemConfig systemConfig = new SystemConfig();

        systemConfig.setDeleteStatus(Boolean.FALSE);

        if (StringUtils.isNotBlank(configName)) {
            systemConfig.setConfigName(configName);
        }
        if (StringUtils.isNotBlank(configType)) {
            systemConfig.setConfigType(configType);
        }
        if (StringUtils.isNotBlank(module)) {
            systemConfig.setModule(module);
        }
        return new QueryWrapper<>(systemConfig);
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
