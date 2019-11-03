package quick.pager.shop.controller.goods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.client.goods.ClassificationClient;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.response.Response;

@Api(description = "商品分类")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class ClassificationManageController {

    @Autowired
    private ClassificationClient classificationClient;

    @ApiOperation("商品分类列表")
    @PostMapping("/classification/list")
    public Response classification(@RequestBody ClassificationDTO dto) {
        return classificationClient.classificationList(dto);
    }

    @ApiOperation("商品分类树形结构")
    @PostMapping("/classification/tree")
    public Response classificationTree() {
        return classificationClient.classificationTree();
    }

    @ApiOperation("商品分类修改")
    @PutMapping("/classification/modify")
    public Response modifyClassification(@RequestBody ClassificationDTO dto) {
        return classificationClient.modifyClassification(dto);
    }
}
