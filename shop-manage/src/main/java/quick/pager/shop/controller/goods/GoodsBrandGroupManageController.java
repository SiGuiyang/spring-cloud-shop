package quick.pager.shop.controller.goods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.client.goods.GoodsBrandGroupClient;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.goods.GoodsBrandGroupDTO;
import quick.pager.shop.model.goods.GoodsBrandGroup;
import quick.pager.shop.response.Response;

/**
 * 商品管理 -> 品牌组
 *
 * @author siguiyang
 */
@Api(description = "商品品牌组管理")
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class GoodsBrandGroupManageController {

    @Autowired
    private GoodsBrandGroupClient goodsBrandGroupClient;

    @ApiOperation("新建或者修改商品品牌组")
    @RequestMapping(value = "/brand/group/create", method = RequestMethod.POST)
    public Response create(@RequestBody GoodsBrandGroupDTO dto) {
        Response response;
        if (Constants.Event.ADD.equals(dto.getEvent())) {
            response = goodsBrandGroupClient.create(dto);
        } else {
            response = goodsBrandGroupClient.modify(dto);
        }
        return response;
    }

    @ApiOperation("商品品牌组列表")
    @RequestMapping(value = "/brand/group/list", method = RequestMethod.POST)
    public Response<List<GoodsBrandGroup>> list(@RequestBody GoodsBrandGroupDTO dto) {
        return goodsBrandGroupClient.list(dto);
    }


    @ApiOperation("商品品牌组所有列表")
    @RequestMapping(value = "/brand/group/listAll", method = RequestMethod.POST)
    public Response<List<GoodsBrandGroup>> listAll() {
        return goodsBrandGroupClient.listAll();
    }

}
