package quick.pager.shop.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import quick.pager.shop.platform.mapper.SystemConfigMapper;
import quick.pager.shop.platform.model.SystemConfig;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.service.SystemConfigService;
import quick.pager.shop.response.Response;

@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {


    @Override
    public List<SystemConfig> queryList(SystemConfigOtherRequest request) {
        SystemConfig systemConfig = new SystemConfig();

        systemConfig.setDeleteStatus(Boolean.FALSE);

        if (StringUtils.isNotBlank(request.getConfigName())) {
            systemConfig.setConfigName(request.getConfigName());
        }
        if (StringUtils.isNotBlank(request.getConfigType())) {
            systemConfig.setConfigType(request.getConfigType());
        }
        if (StringUtils.isNotBlank(request.getModule())) {
            systemConfig.setModule(request.getModule());
        }

        return this.baseMapper.selectList(new QueryWrapper<>(systemConfig));
    }

    @Override
    public Response<List<SystemConfig>> queryPage(SystemConfigPageRequest request) {

        SystemConfig systemConfig = new SystemConfig();

        systemConfig.setDeleteStatus(Boolean.FALSE);

        if (StringUtils.isNotBlank(request.getConfigName())) {
            systemConfig.setConfigName(request.getConfigName());
        }
        if (StringUtils.isNotBlank(request.getConfigType())) {
            systemConfig.setConfigType(request.getConfigType());
        }
        if (StringUtils.isNotBlank(request.getModule())) {
            systemConfig.setModule(request.getModule());
        }

        return this.toPage(request.getPage(), request.getPageSize(), new QueryWrapper<>(systemConfig));
    }
}
