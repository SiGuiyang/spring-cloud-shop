package quick.pager.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.user.service.GoodsCartService;

/**
 * 购物车
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class UserGoodsCartController {

    @Autowired
    private GoodsCartService goodsCartService;

//    /**
//     * 购物车列表
//     */
//    @PostMapping("/goodsCarts")
//    public Response goodsCarts(@RequestBody @Valid GoodsCartDTO dto, BindingResult bindingResult) {
//        BindingResultUtils.getFieldErrorMessage(bindingResult);
//        return goodsCartService.goodsCarts(dto);
//    }
//
//    /**
//     * 添加 | 删除 购物车
//     */
//    @PostMapping("/modifyGoodsCart")
//    public Response modifyGoodsCart(@RequestBody @Valid GoodsCartDTO dto, BindingResult bindingResult) {
//        BindingResultUtils.getFieldErrorMessage(bindingResult);
//        return goodsCartService.modifyGoodsCart(dto);
//    }

}
