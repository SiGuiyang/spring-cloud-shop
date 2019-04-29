package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.ClassificationDTO;
import quick.pager.shop.service.ClassificationService;

/**
 * 商品分类
 *
 * @author siguiyang
 */
@Api(description = "商品分类")
@RestController
@RequestMapping(Constants.Module.GOODS)
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @ApiOperation("商品分类列表")
    @RequestMapping(value = "/classification/list", method = RequestMethod.POST)
    public Response goodsClassList(String className) {
        ClassificationDTO dto = new ClassificationDTO();
        dto.setClassName(className);
        dto.setEvent(Constants.Event.LIST);
        return classificationService.doService(dto);
    }

    @ApiOperation("商品分类修改")
    @RequestMapping(value = "/classification/modify", method = RequestMethod.PUT)
    public Response modifyClassification(@RequestBody ClassificationDTO dto) {
        dto.setEvent(Constants.Event.MODIFY);
        return classificationService.doService(dto);
    }
}
