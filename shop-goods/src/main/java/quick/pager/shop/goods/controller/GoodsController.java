package quick.pager.shop.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.shop.goods.service.GoodsDetailService;

/**
 * APP展示商品
 *
 * @author siguiyang
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsDetailService goodsDetailService;

    /**
     * 商品搜索
     */
    @RequestMapping(value = "/goods/search", method = RequestMethod.POST)
    public Response goodsSearch() {
        return null;
    }

    /**
     * 查看商品详情
     */
    @RequestMapping(value = "/goods/detail/{goodsId}", method = RequestMethod.POST)
    public Response goodsDetail(@PathVariable("goodsId") Long goodsId) {

        return goodsDetailService.doService(DTO.builder().id(goodsId).build());

    }
}
