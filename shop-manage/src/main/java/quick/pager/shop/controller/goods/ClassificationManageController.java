package quick.pager.shop.controller.goods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.ClassificationDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.goods.ClassificationService;

@Api(description = "商品分类")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class ClassificationManageController {

    @Autowired
    private ClassificationService classificationService;

    @ApiOperation("商品分类列表")
    @PostMapping("/classification/list")
    public Response classification(@RequestParam("className") String className) {
        return classificationService.classificationList(className);
    }

    @ApiOperation("商品分类修改")
    @PutMapping("/classification/modify")
    public Response modifyClassification(@Valid ClassificationDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return classificationService.modifyClassification(dto);
    }
}
