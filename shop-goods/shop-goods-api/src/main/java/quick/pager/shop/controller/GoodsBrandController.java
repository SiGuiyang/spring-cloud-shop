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
import quick.pager.shop.goods.request.brand.GoodsBrandPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandResponse;
import quick.pager.shop.service.GoodsBrandService;
import quick.pager.shop.user.response.Response;

/**
 * 商品品牌
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsBrandController {

    @Autowired
    private GoodsBrandService goodsBrandService;

    /**
     * 新增品牌
     */
    @PostMapping("/brand/create")
    public Response<Long> create(@RequestBody GoodsBrandSaveRequest request) {
        return goodsBrandService.create(request);
    }

    /**
     * 修改品牌
     */
    @PutMapping("/brand/modify")
    public Response<Long> modify(@RequestBody GoodsBrandSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return goodsBrandService.modify(request);
    }

    /**
     * 品牌列表
     */
    @PostMapping("/brand/page")
    public Response<List<GoodsBrandResponse>> page(@RequestBody GoodsBrandPageRequest request) {
        return goodsBrandService.queryPage(request);
    }
}
