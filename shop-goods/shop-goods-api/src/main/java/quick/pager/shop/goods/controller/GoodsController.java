package quick.pager.shop.goods.controller;

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
import quick.pager.shop.goods.request.GoodsPageRequest;
import quick.pager.shop.goods.request.GoodsSaveRequest;
import quick.pager.shop.goods.response.GoodsResponse;
import quick.pager.shop.goods.service.GoodsService;
import quick.pager.shop.response.Response;

/**
 * 商品主表信息
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 保存
     *
     * @param request 请求参数
     * @return 主键
     */
    @PostMapping("/product/create")
    public Response<Long> create(@RequestBody GoodsSaveRequest request) {
        return goodsService.create(request);
    }

    /**
     * 编辑
     *
     * @param request 请求参数
     * @return 主键
     */
    @PutMapping("/product/modify")
    public Response<Long> modify(@RequestBody GoodsSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return goodsService.modify(request);
    }

    /**
     * 商品列表
     *
     * @param request 请求参数
     * @return 商品列表
     */
    @PostMapping("/product/page")
    public Response<List<GoodsResponse>> page(@RequestBody GoodsPageRequest request) {
        return goodsService.queryPage(request);
    }


}
