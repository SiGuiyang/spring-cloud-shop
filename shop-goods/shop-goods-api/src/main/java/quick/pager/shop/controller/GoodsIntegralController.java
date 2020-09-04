package quick.pager.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.user.response.Response;

/**
 * 积分商城
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsIntegralController {

    /**
     * 积分商城列表
     */
    @RequestMapping(value = "/integral/list", method = RequestMethod.POST)
    public Response goodsIntegral() {
        return null;
    }
}
