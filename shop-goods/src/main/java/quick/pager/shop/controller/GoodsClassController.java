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
import quick.pager.shop.dto.GoodsDTO;
import quick.pager.shop.service.GoodsClassService;
import quick.pager.shop.service.GoodsModifyService;

/**
 * 商品分类
 *
 * @author siguiyang
 */
@Api(description = "商品分类")
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsClassController {

    @Autowired
    private GoodsClassService goodsClassService;
    @Autowired
    private GoodsModifyService goodsModifyService;

    @ApiOperation("商品分类列表")
    @RequestMapping(value = "/classification/list", method = RequestMethod.POST)
    public Response goodsClassList(String className) {
        ClassificationDTO dto = new ClassificationDTO();
        dto.setClassName(className);
        return goodsClassService.doService(dto);
    }

    @RequestMapping(value = "/classification/modify", method = RequestMethod.POST)
    public Response modifyGoodsClass(@RequestBody GoodsDTO request) {
        ClassificationDTO dto = new ClassificationDTO();
        dto.setId(request.getId());
        dto.setClassName(request.getClassName());
        dto.setIcon(request.getIcon());
        dto.setCreateUser(request.getCreateUser());
        dto.setEvent(Constants.Event.MODIFY);
        return goodsModifyService.doService(dto);
    }
}
