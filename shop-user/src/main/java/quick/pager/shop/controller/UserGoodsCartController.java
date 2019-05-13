package quick.pager.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.GoodsCartDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsCartService;

@Api(description = "购物车")
@RestController
@RequestMapping(Constants.Module.USER)
public class UserGoodsCartController {

    @Autowired
    private GoodsCartService goodsCartService;

    @ApiOperation("购物车列表")
    @PostMapping("/goodsCarts")
    public Response goodsCarts(@RequestBody GoodsCartDTO dto) {
        return goodsCartService.goodsCarts(dto);
    }

    @ApiOperation("添加 | 删除 购物车")
    @PostMapping("/modifyGoodsCart")
    public Response modifyGoodsCart(@RequestBody GoodsCartDTO dto) {

        return goodsCartService.modifyGoodsCart(dto);
    }

}
