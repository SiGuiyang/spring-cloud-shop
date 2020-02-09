package quick.pager.shop.goods.controller;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.model.GoodsSku;
import quick.pager.shop.goods.request.sku.GoodsSkuPageRequest;
import quick.pager.shop.goods.request.sku.GoodsSkuSaveRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.goods.service.GoodsSkuService;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.BeanCopier;

/**
 * 商品sku
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsSkuController {

    @Autowired
    private GoodsSkuService goodsSkuService;

    /**
     * 商品sku新增
     *
     * @param request 请求参数
     * @return sku主键
     */
    @PostMapping("/sku/create")
    public Response<Long> create(@RequestBody GoodsSkuSaveRequest request) {
        return goodsSkuService.create(request);
    }

    /**
     * 商品sku新增
     *
     * @param request 请求参数
     * @return sku主键
     */
    @PutMapping("/sku/modify")
    public Response<Long> modify(@RequestBody GoodsSkuSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return goodsSkuService.modify(request);
    }

    /**
     * 商品sku新增
     *
     * @param request 请求参数
     * @return sku集
     */
    @PostMapping("/sku/page")
    public Response<List<GoodsSkuResponse>> queryPage(@RequestBody GoodsSkuPageRequest request) {
        Response<List<GoodsSku>> listResponse = goodsSkuService.queryPage(request);

        return Response.toResponse(Optional.ofNullable(listResponse.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::conv).collect(Collectors.toList())
                , listResponse.getTotal());
    }


    private GoodsSkuResponse conv(GoodsSku sku) {
        GoodsSkuResponse response = new GoodsSkuResponse();
        BeanCopier.create(sku, response).copy();
        return response;
    }
}
