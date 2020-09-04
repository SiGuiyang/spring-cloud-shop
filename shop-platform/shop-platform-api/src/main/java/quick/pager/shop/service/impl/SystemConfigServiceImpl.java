package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import quick.pager.shop.service.RedisService;
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
    private RedisService redisService;

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
        systemConfig.setConfigStatus(Boolean.FALSE);
        List<SystemConfig> systemConfigs = this.baseMapper.selectList(new QueryWrapper<>(systemConfig));

        Map<String, List<SystemConfigDTO>> listMap = Maps.newHashMap();
        for (SystemConfig config : systemConfigs) {
            SystemConfigDetail detail = new SystemConfigDetail();
            detail.setDeleteStatus(Boolean.FALSE);
            detail.setConfigStatus(Boolean.FALSE);
            detail.setConfigKey(config.getConfigType());

            List<SystemConfigDetail> systemConfigDetails = systemConfigDetailMapper.selectList(new QueryWrapper<>(detail));
            List<SystemConfigDTO> dtos = systemConfigDetails.stream().map(detailItem -> {
                SystemConfigDTO dto = new SystemConfigDTO();
                dto.setConfigType(detailItem.getConfigType());
                dto.setConfigValue(detailItem.getConfigValue());
                dto.setConfigName(detailItem.getConfigName());
                return dto;
            }).collect(Collectors.toList());
            listMap.put(config.getConfigType(), dtos);
        }

        listMap.forEach((k, v) -> redisService.set(k, new ArrayList<>(v), 24 * 60 * 60L * 2));
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
