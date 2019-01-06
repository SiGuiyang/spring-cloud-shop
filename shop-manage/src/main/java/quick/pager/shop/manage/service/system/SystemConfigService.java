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
import quick.pager.common.dto.DTO;
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
    public Response doService(DTO dto) {

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

                PageHelper.startPage(systemConfigDTO.getPage(), systemConfigDTO.getPageSize());

                List<SystemConfig> systemConfigs = systemConfigMapper.selectSystemConfig(systemConfigDTO.getConfigName(),
                        systemConfigDTO.getModule());
                PageInfo<SystemConfig> pageInfo = new PageInfo<>(systemConfigs);

                response.setData(pageInfo.getList());
                response.setTotal(pageInfo.getTotal());

                break;
        }

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
            systemConfigMapper.insertSelective(config);
        } else {
            systemConfigMapper.updateByPrimaryKeySelective(config);
        }
    }

}
