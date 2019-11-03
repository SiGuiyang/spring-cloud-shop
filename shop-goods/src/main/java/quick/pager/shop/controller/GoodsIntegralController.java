package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;

/**
 * 积分商城
 *
 * @author siguiyang
 */
@Api(description = "积分商城")
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsIntegralController {

    @ApiOperation("积分商城列表")
    @RequestMapping(value = "/integral/list", method = RequestMethod.POST)
    public Response goodsIntegral() {
        return null;
    }
}
