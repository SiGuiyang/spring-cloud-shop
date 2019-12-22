package quick.pager.shop.goods.controller;

import java.util.Collections;
import java.util.List;
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
import quick.pager.shop.utils.DateUtils;

/**
 * 商品品牌
 *
 * @author siguiyang
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
    public Response create(@RequestBody GoodsBrandSaveRequest request) {
        GoodsBrand brand = this.convert(request);
        brand.setDeleteStatus(Boolean.FALSE);
        brand.setCreateTime(DateUtils.dateTime());
        goodsBrandService.save(brand);
        return new Response();
    }

    /**
     * 修改品牌
     */
    @PutMapping("/brand/modify")
    public Response modify(@RequestBody GoodsBrandSaveRequest param) {
        GoodsBrand brand = this.convert(param);
        goodsBrandService.updateById(brand);
        return new Response();
    }

    /**
     * 品牌列表
     */
    @PostMapping("/brand/list")
    public Response<List<GoodsBrandResponse>> list(@RequestBody GoodsBrandPageRequest request) {
        Response<List<GoodsBrand>> response = goodsBrandService.goodsBrandList(request);
        List<GoodsBrandResponse> result = Collections.emptyList();
        if (ResponseStatus.Code.SUCCESS != response.getCode()) {
            result = response.getData().stream().map(this::convert).collect(Collectors.toList());
        }

        return Response.toResponse(result, response.getTotal());
    }

    /**
     * 品牌列表显示
     */
    @PostMapping("/brand/app/list")
    public Response list() {


        return null;
    }

    /**
     * DTO -> db model
     */
    private GoodsBrand convert(GoodsBrandSaveRequest request) {
        GoodsBrand brand = new GoodsBrand();
        BeanCopier.create(request, brand).copy();
        return brand;
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
