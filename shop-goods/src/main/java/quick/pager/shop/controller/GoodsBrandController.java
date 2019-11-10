package quick.pager.shop.controller;

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
import quick.pager.shop.dto.goods.GoodsBrandDTO;
import quick.pager.shop.model.goods.GoodsBrand;
import quick.pager.shop.model.goods.GoodsBrandGroup;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsBrandGroupService;
import quick.pager.shop.service.GoodsBrandService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;
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
    public Response create(@RequestBody GoodsBrandDTO dto) {
        GoodsBrand brand = this.convert(dto);
        brand.setDeleteStatus(Boolean.FALSE);
        brand.setCreateTime(DateUtils.dateTime());
        goodsBrandService.save(brand);
        return new Response();
    }

    /**
     * 修改品牌
     */
    @PutMapping("/brand/modify")
    public Response modify(@RequestBody GoodsBrandDTO dto) {
        GoodsBrand brand = this.convert(dto);
        goodsBrandService.updateById(brand);
        return new Response();
    }

    /**
     * 品牌列表
     */
    @PostMapping("/brand/list")
    public Response<List<GoodsBrandDTO>> list(@RequestBody GoodsBrandDTO dto) {
        Response<List<GoodsBrand>> response = goodsBrandService.goodsBrandList(dto);
        List<GoodsBrandDTO> result = Collections.emptyList();
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
    private GoodsBrand convert(GoodsBrandDTO dto) {
        GoodsBrand brand = new GoodsBrand();
        BeanCopier.create(dto, brand, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true)).copy();
        return brand;
    }

    /**
     * db model -> DTO
     */
    private GoodsBrandDTO convert(GoodsBrand goodsBrand) {
        GoodsBrandDTO dto = new GoodsBrandDTO();
        BeanCopier.create(goodsBrand, dto, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true)).copy();
        GoodsBrandGroup brandGroup = goodsBrandGroupService.getById(goodsBrand.getBrandGroupId());
        dto.setBrandGroupName(brandGroup.getBrandGroupName());
        return dto;
    }
}
