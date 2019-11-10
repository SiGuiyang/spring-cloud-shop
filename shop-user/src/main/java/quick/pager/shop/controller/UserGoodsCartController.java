package quick.pager.shop.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.GoodsCartDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsCartService;

/**
 * 购物车
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class UserGoodsCartController {

    @Autowired
    private GoodsCartService goodsCartService;

    /**
     * 购物车列表
     */
    @PostMapping("/goodsCarts")
    public Response goodsCarts(@RequestBody @Valid GoodsCartDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return goodsCartService.goodsCarts(dto);
    }

    /**
     * 添加 | 删除 购物车
     */
    @PostMapping("/modifyGoodsCart")
    public Response modifyGoodsCart(@RequestBody @Valid GoodsCartDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return goodsCartService.modifyGoodsCart(dto);
    }

}
