package quick.pager.shop.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.param.system.GeneratorPageParam;
import quick.pager.shop.service.GeneratorService;
import quick.pager.shop.user.response.Response;

/**
 * 代码生成器
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    /**
     * 所有表
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_GENERATE')")
    @PostMapping("/generator/tables")
    public Response tables(@RequestBody GeneratorPageParam dto) {

        return generatorService.tables(dto);
    }

    /**
     * 表的元素信息
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_GENERATE')")
    @GetMapping("generator/tables")
    public Response tables(@RequestParam String tableSchema, @RequestParam String tableName) {

        return generatorService.tables(tableSchema, tableName);
    }

    /**
     * 代码自动生成
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_GENERATE')")
    @PostMapping("/generator")
    public Response generator(@RequestBody GeneratorPageParam dto) {
        return generatorService.generator(dto.getTableSchema(), dto.getTableName());
    }
}
