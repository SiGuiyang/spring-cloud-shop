package quick.pager.shop.manage.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.manage.dto.SystemConfigDTO;
import quick.pager.shop.manage.mapper.SystemConfigMapper;
import quick.pager.shop.model.common.SystemConfig;

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
                modifySystemConfig(systemConfigDTO);
                break;
            case Constants.Event.MODIFY:
                modifySystemConfig(systemConfigDTO);
                break;
            case Constants.Event.LIST:
                response = getSystemConfigList(systemConfigDTO);
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;
    }

    /**
     * 配置项列表
     */
    private Response getSystemConfigList(SystemConfigDTO systemConfigDTO) {

        PageHelper.startPage(systemConfigDTO.getPage(), systemConfigDTO.getPageSize());

        List<SystemConfig> systemConfigs = systemConfigMapper.selectSystemConfig(systemConfigDTO.getConfigName(),
                systemConfigDTO.getModule());
        PageInfo<SystemConfig> pageInfo = new PageInfo<>(systemConfigs);

        Response<List<SystemConfig>> response = new Response<>();
        response.setData(pageInfo.getList());
        response.setTotal(pageInfo.getTotal());

        return response;
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
