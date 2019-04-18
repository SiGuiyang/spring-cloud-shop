package quick.pager.shop.controller.common;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.GeneratorDTO;
import quick.pager.shop.model.Columns;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GeneratorService;


/**
 * 此功能只提供给开发者使用
 *
 * @author siguiyang
 */
@Api(description = "自动生成代码")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @ApiOperation("所有表")
    @PostMapping("/generator/tables")
    public Response tables(GeneratorDTO dto) {

        return generatorService.tables(dto);
    }

    @ApiOperation("表的元素信息")
    @GetMapping("generator/tables")
    public Response tables(@RequestParam("tableSchema") String tableSchema, @RequestParam("tableName") String tableName) {

        return generatorService.tables(tableSchema,tableName);
    }


    @ApiOperation("代码自动生成")
    @PostMapping("/generator")
    public Response generator(@RequestParam("columns") String columns, @RequestParam("tableName") String tableName) {
        return generatorService.generator(JSON.parseArray(columns, Columns.class), tableName);
    }
}
