package quick.pager.shop.service.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.SystemConfigDTO;
import quick.pager.shop.mapper.SystemConfigMapper;
import quick.pager.shop.model.SystemConfig;
import quick.pager.shop.utils.DateUtils;
import quick.pager.shop.utils.PrincipalUtils;

/**
 * 系统配置服务
 *
 * @author siguiyang
 */
@Service
public class SystemConfigService implements IService {

    @Autowired
    private SystemConfigMapper systemConfigMapper;

    @Override
    public Response doService(BaseDTO dto) {

        SystemConfigDTO systemConfigDTO = (SystemConfigDTO) dto;

        Response response = new Response();

        switch (systemConfigDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                modifySystemConfig(systemConfigDTO);
                break;
            case Constants.Event.LIST:
                response = getSystemConfigList(systemConfigDTO);
                break;
            case Constants.Event.DELETE:
                response = deleteSystemConfig(systemConfigDTO.getId());
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;
    }

    /**
     * 删除
     */
    private Response deleteSystemConfig(Long id) {
        SystemConfig config = new SystemConfig();
        config.setId(id);
        config.setDeleteStatus(Boolean.TRUE);
        systemConfigMapper.updateById(config);
        return new Response();
    }

    /**
     * 配置项列表
     */
    private Response getSystemConfigList(SystemConfigDTO systemConfigDTO) {

        Page<SystemConfig> page = new Page<>(systemConfigDTO.getPage(), systemConfigDTO.getPageSize());

        QueryWrapper<SystemConfig> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(systemConfigDTO.getConfigName())) {
            queryWrapper.likeRight("config_name", systemConfigDTO.getConfigName());
        }
        if (!StringUtils.isEmpty(systemConfigDTO.getModule())) {
            queryWrapper.eq("module", systemConfigDTO.getModule());
        }
        return Response.toResponse(systemConfigMapper.selectPage(page, queryWrapper));
    }

    /**
     * 修改配置
     */
    private void modifySystemConfig(SystemConfigDTO dto) {
        SystemConfig config = new SystemConfig();
        BeanCopier beanCopier = BeanCopier.create(SystemConfigDTO.class, SystemConfig.class, false);
        beanCopier.copy(dto, config, null);

        Date date = DateUtils.now();
        if (Constants.Event.ADD.equals(dto.getEvent())) {
            config.setCreateTime(date);
            config.setUpdateTime(date);
            config.setDeleteStatus(Boolean.FALSE);
            systemConfigMapper.insert(config);
        } else {
            config.setUpdateUser(PrincipalUtils.getPrincipal().getName());
            config.setUpdateTime(date);
            systemConfigMapper.updateById(config);
        }
    }

}
