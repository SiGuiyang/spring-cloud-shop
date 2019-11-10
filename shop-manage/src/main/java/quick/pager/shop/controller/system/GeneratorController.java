package quick.pager.shop.controller.system;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.GeneratorDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GeneratorService;

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
    @GetMapping("/generator/tables")
    public Response tables(@Valid GeneratorDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);

        return generatorService.tables(dto);
    }

    /**
     * 表的元素信息
     */
    @PostMapping("generator/tables")
    public Response tables(@RequestBody GeneratorDTO dto) {

        return generatorService.tables(dto.getTableSchema(), dto.getTableName());
    }

    /**
     * 代码自动生成
     */
    @PostMapping("/generator")
    public Response generator(@RequestBody GeneratorDTO dto) {
        return generatorService.generator(dto.getTableSchema(), dto.getTableName());
    }
}
