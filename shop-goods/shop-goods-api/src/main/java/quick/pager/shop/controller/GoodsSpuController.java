package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.request.spu.GoodsSpuPageRequest;
import quick.pager.shop.goods.request.spu.GoodsSpuSaveRequest;
import quick.pager.shop.goods.response.spu.GoodsSpuResponse;
import quick.pager.shop.service.GoodsSpuService;
import quick.pager.shop.user.response.Response;

/**
 * 商品spu
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsSpuController {

    @Autowired
    private GoodsSpuService goodsSpuService;

    /**
     * 商品spu新增
     */
    @PostMapping("/spu/create")
    public Response<Long> create(@RequestBody GoodsSpuSaveRequest request) {
        return goodsSpuService.create(request);
    }

    /**
     * 商品spu修改
     */
    @PutMapping("/spu/modify")
    public Response<Long> modify(@RequestBody GoodsSpuSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return goodsSpuService.modify(request);
    }

    /**
     * 商品spu列表分页
     *
     * @param request 请求参数
     * @return 数据响应
     */
    @PostMapping("/spu/page")
    public Response<List<GoodsSpuResponse>> page(@RequestBody GoodsSpuPageRequest request) {
        return goodsSpuService.queryPage(request);
    }

}
