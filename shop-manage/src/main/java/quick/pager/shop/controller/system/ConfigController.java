package quick.pager.shop.controller.system;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.SystemConfigDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.system.SystemConfigService;

/**
 * 系统配置
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class ConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    /**
     * 系统菜单列表
     */
    @PostMapping("/config/list")
    public Response systemConfigList(@RequestBody SystemConfigDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return systemConfigService.doService(dto);
    }

    /**
     * 新增
     */
    @PostMapping(value = "/config")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response addConfigs(@Valid @RequestBody SystemConfigDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        dto.setEvent(Constants.Event.ADD);
        return systemConfigService.doService(dto);
    }

    /**
     * 修改
     */
    @PutMapping(value = "/config")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response modifyConfigs(@Valid @RequestBody SystemConfigDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        dto.setEvent(Constants.Event.MODIFY);
        return systemConfigService.doService(dto);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/config/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response delConfigs(@PathVariable("id") Long id) {
        SystemConfigDTO dto = new SystemConfigDTO();
        dto.setEvent(Constants.Event.DELETE);
        dto.setId(id);
        return systemConfigService.doService(dto);
    }
}
