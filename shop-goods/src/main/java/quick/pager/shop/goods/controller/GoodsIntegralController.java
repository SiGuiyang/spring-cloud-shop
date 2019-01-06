package quick.pager.shop.goods.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;

/**
 * 积分商城
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
@Api(description = "积分商城")
public class GoodsIntegralController {

    @ApiOperation("积分商城列表")
    @RequestMapping(value = "/integral/list", method = RequestMethod.POST)
    public Response goodsIntegral() {
        return null;
    }
}
