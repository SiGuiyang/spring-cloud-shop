package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;

@Api(description = "商品")
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsController {

}
