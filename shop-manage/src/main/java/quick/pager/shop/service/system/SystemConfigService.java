package quick.pager.shop.service.system;

import com.github.pagehelper.PageHelper;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.SystemConfigDTO;
import quick.pager.shop.mapper.SystemConfigMapper;
import quick.pager.shop.model.SystemConfig;

/**
 * 系统配置服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
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
        systemConfigMapper.updateByPrimaryKeySelective(config);
        return new Response();
    }

    /**
     * 配置项列表
     */
    private Response getSystemConfigList(SystemConfigDTO systemConfigDTO) {

        PageHelper.startPage(systemConfigDTO.getPage(), systemConfigDTO.getPageSize());

        List<SystemConfig> systemConfigs = systemConfigMapper.selectSystemConfig(systemConfigDTO.getConfigName(),
                systemConfigDTO.getModule());
        return Response.toResponse(systemConfigs);
    }

    /**
     * 修改配置
     */
    private void modifySystemConfig(SystemConfigDTO dto) {
        SystemConfig config = new SystemConfig();
        BeanUtils.copyProperties(dto, config);

        if (Constants.Event.ADD.equals(dto.getEvent())) {
            config.setCreateTime(new Date());
            config.setDeleteStatus(false);
            systemConfigMapper.insertSelective(config);
        } else {
            systemConfigMapper.updateByPrimaryKeySelective(config);
        }
    }

}
