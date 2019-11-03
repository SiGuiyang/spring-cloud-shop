package quick.pager.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(description = "商品品牌")
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsBrandController {

    @Autowired
    private GoodsBrandService goodsBrandService;
    @Autowired
    private GoodsBrandGroupService goodsBrandGroupService;

    @ApiOperation("新增品牌")
    @RequestMapping(value = "/brand/create", method = RequestMethod.POST)
    public Response create(@RequestBody GoodsBrandDTO dto) {
        GoodsBrand brand = this.convert(dto);
        brand.setDeleteStatus(Boolean.FALSE);
        brand.setCreateTime(DateUtils.now());
        brand.setUpdateTime(DateUtils.now());

        boolean save = goodsBrandService.save(brand);
        if (save) {
            return new Response();
        }

        return new Response(ResponseStatus.Code.FAIL_CODE, "新增品牌失败");
    }

    @ApiOperation("修改品牌")
    @RequestMapping(value = "/brand/modify", method = RequestMethod.POST)
    public Response modify(@RequestBody GoodsBrandDTO dto) {
        GoodsBrand brand = this.convert(dto);
        brand.setCreateUser(null);
        brand.setUpdateTime(DateUtils.now());
        boolean update = goodsBrandService.updateById(brand);
        if (update) {
            return new Response();
        }

        return new Response(ResponseStatus.Code.FAIL_CODE, "修改品牌失败");
    }

    @ApiOperation("品牌列表")
    @RequestMapping(value = "/brand/list", method = RequestMethod.POST)
    public Response<List<GoodsBrandDTO>> list(@RequestBody GoodsBrandDTO dto) {

        QueryWrapper<GoodsBrand> qw = new QueryWrapper<>();
        qw.eq("delete_status", Boolean.FALSE);

        if (!StringUtils.isEmpty(dto.getBrandName())) {
            qw.likeRight("brand_name", dto.getBrandName());
        }

        if (!CollectionUtils.isEmpty(dto.getTimeRange())) {
            qw.ge("create_time", dto.getTimeRange().get(0));
            qw.le("create_time", dto.getTimeRange().get(1));
        }

        IPage<GoodsBrand> page = goodsBrandService.page(new Page<>(dto.getPage(), dto.getPageSize()), qw);

        List<GoodsBrandDTO> collect = page.getRecords().stream().map(this::convert).collect(Collectors.toList());

        return Response.toResponse(collect, page.getTotal());
    }

    @ApiOperation("App 品牌列表显示")
    @RequestMapping(value = "/brand/app/list", method = RequestMethod.POST)
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
