package quick.pager.shop.controller.system;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.param.system.SystemConfigParam;
import quick.pager.shop.service.system.SystemConfigService;
import quick.pager.shop.user.response.Response;

/**
 * 系统配置
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class ConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    /**
     * 系统菜单列表
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_CONFIG')")
    @PostMapping("/config/page")
    public Response page(@RequestBody SystemConfigParam dto) {
        return systemConfigService.queryPage(dto);
    }

    /**
     * 系统菜单列表
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_CONFIG')")
    @GetMapping("/config/list")
    public Response list(SystemConfigParam dto) {
        return systemConfigService.queryList(dto);
    }

    /**
     * 新增
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_CONFIG_CREATE')")
    @PostMapping(value = "/config/create")
    public Response create(@RequestBody SystemConfigParam dto) {
        return systemConfigService.create(dto);
    }

    /**
     * 修改
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_CONFIG_MODIFY')")
    @PutMapping(value = "/config/modify")
    public Response modify(@Valid @RequestBody SystemConfigParam dto) {
        return systemConfigService.modify(dto);
    }

    /**
     * 删除
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_CONFIG_DELETE')")
    @DeleteMapping(value = "/config/{id}/delete")
    public Response delete(@PathVariable("id") Long id) {
        return systemConfigService.delete(id);
    }
}
