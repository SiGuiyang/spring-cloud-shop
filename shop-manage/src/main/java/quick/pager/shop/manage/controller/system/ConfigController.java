package quick.pager.shop.manage.controller.system;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.manage.param.system.SystemConfigParam;
import quick.pager.shop.manage.service.system.SystemConfigService;
import quick.pager.shop.response.Response;

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
    @PostMapping("/config/list")
    public Response list(@RequestBody SystemConfigParam dto) {
        return systemConfigService.queryPage(dto);
    }

    /**
     * 新增
     */
    @PostMapping(value = "/config/create")
    public Response create(@RequestBody SystemConfigParam dto) {
        return systemConfigService.create(dto);
    }

    /**
     * 修改
     */
    @PutMapping(value = "/config/modify")
    public Response modify(@Valid @RequestBody SystemConfigParam dto) {
        return systemConfigService.modify(dto);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/config/{id}/delete")
    public Response delete(@PathVariable("id") Long id) {
        return systemConfigService.delete(id);
    }
}
