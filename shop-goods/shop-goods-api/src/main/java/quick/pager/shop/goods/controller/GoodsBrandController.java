package quick.pager.shop.goods.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.model.GoodsBrand;
import quick.pager.shop.goods.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandResponse;
import quick.pager.shop.goods.service.GoodsBrandGroupService;
import quick.pager.shop.goods.service.GoodsBrandService;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.BeanCopier;

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
    @Autowired
    private GoodsBrandGroupService goodsBrandGroupService;

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
        Response<List<GoodsBrand>> response = goodsBrandService.queryPage(request);
        return Response.toResponse(response.getData().stream().map(this::convert).collect(Collectors.toList())
                , response.getTotal());
    }

    /**
     * db model -> DTO
     */
    private GoodsBrandResponse convert(GoodsBrand goodsBrand) {
        GoodsBrandResponse response = new GoodsBrandResponse();
        BeanCopier.create(goodsBrand, response).copy();
        GoodsBrandGroup brandGroup = goodsBrandGroupService.getById(goodsBrand.getBrandGroupId());
        response.setBrandGroupName(brandGroup.getBrandGroupName());
        return response;
    }
}
