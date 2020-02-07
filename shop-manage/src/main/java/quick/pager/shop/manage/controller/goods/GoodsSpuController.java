package quick.pager.shop.manage.controller.goods;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.manage.param.goods.GoodsSpuPageParam;
import quick.pager.shop.manage.param.goods.GoodsSpuSaveParam;
import quick.pager.shop.response.Response;

/**
 * 商品spu
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.MANAGE)
public class GoodsSpuController {

    /**
     * 新增
     */
    @PostMapping("/goods/spu/create")
    public Response create(@RequestBody GoodsSpuSaveParam param) {
        return null;
    }

    /**
     * 新增
     */
    @PostMapping("/goods/spu/modify")
    public Response modify(@RequestBody GoodsSpuSaveParam param) {
        return null;
    }

    @GetMapping("/goods/spu/{id}/info")
    public Response info(@PathVariable Long id) {
        return null;
    }

    /**
     * 分页列表
     */
    @PostMapping("/goods/spu/queryPage")
    public Response queryPage(@RequestBody GoodsSpuPageParam param) {
        return null;
    }


}
