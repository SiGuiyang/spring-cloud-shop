package quick.pager.shop.controller.goods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.client.goods.GoodsBrandClient;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.goods.GoodsBrandDTO;
import quick.pager.shop.response.Response;

/**
 * 商品管理-->品牌管理
 *
 * @author siguiyang
 */
@Api(description = "品牌管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsBrandManageController {

    @Autowired
    private GoodsBrandClient goodsBrandClient;

    @ApiOperation("品牌列表")
    @PostMapping("/brand/list")
    public Response list(@RequestBody GoodsBrandDTO dto) {

        return goodsBrandClient.list(dto);
    }

    @ApiOperation("品牌创建或修改")
    @PostMapping("/brand/create")
    public Response create(@RequestBody GoodsBrandDTO dto) {
        Response response;
        // 新增
        if (Constants.Event.ADD.equals(dto.getEvent())) {
            response = goodsBrandClient.create(dto);
        } else {
            response = goodsBrandClient.modify(dto);
        }
        return response;
    }
}
