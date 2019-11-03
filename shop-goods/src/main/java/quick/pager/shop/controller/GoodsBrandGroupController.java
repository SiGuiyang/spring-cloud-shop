package quick.pager.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.goods.GoodsBrandGroupDTO;
import quick.pager.shop.model.goods.GoodsBrandGroup;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsBrandGroupService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;
import quick.pager.shop.utils.DateUtils;

/**
 * 商品品牌组
 *
 * @author siguiyang
 */
@Api(description = "商品品牌组")
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsBrandGroupController {

    @Autowired
    private GoodsBrandGroupService goodsBrandGroupService;

    @ApiOperation("新建商品品牌组")
    @RequestMapping(value = "/brand/group/create", method = RequestMethod.POST)
    public Response create(@RequestBody GoodsBrandGroupDTO dto) {
        GoodsBrandGroup group = convert(dto);
        group.setCreateTime(DateUtils.now());
        group.setUpdateTime(DateUtils.now());
        group.setDeleteStatus(Boolean.FALSE);
        goodsBrandGroupService.save(group);
        return new Response();
    }

    @ApiOperation("修改商品品牌组")
    @RequestMapping(value = "/brand/group/modify", method = RequestMethod.POST)
    public Response modify(@RequestBody GoodsBrandGroupDTO dto) {
        GoodsBrandGroup group = convert(dto);
        group.setCreateUser(null);
        group.setUpdateTime(DateUtils.now());
        goodsBrandGroupService.updateById(group);
        return new Response();
    }

    @ApiOperation("商品品牌组列表")
    @RequestMapping(value = "/brand/group/list", method = RequestMethod.POST)
    public Response<List<GoodsBrandGroup>> list(@RequestBody GoodsBrandGroupDTO dto) {
        QueryWrapper<GoodsBrandGroup> qw = new QueryWrapper<>();

        qw.eq("delete_status", Boolean.FALSE);

        if (!StringUtils.isEmpty(dto.getBrandGroupName())) {
            qw.likeRight("brand_group_name", dto.getBrandGroupName());
        }

        if (!CollectionUtils.isEmpty(dto.getTimeRange())) {
            qw.ge("create_time", dto.getTimeRange().get(0));
            qw.le("create_time", dto.getTimeRange().get(1));
        }

        qw.orderByDesc("sequence");

        return Response.toResponse(goodsBrandGroupService.page(new Page<>(dto.getPage(), dto.getPageSize()), qw));
    }

    @ApiOperation("商品品牌组所有列表")
    @RequestMapping(value = "/brand/group/listAll", method = RequestMethod.POST)
    public Response<List<GoodsBrandGroup>> listAll() {
        QueryWrapper<GoodsBrandGroup> qw = new QueryWrapper<>();
        qw.eq("delete_status", Boolean.FALSE);
        return Response.toResponse(goodsBrandGroupService.list(qw), 0);
    }

    /**
     * DTO -> db model
     */
    private GoodsBrandGroup convert(GoodsBrandGroupDTO dto) {
        GoodsBrandGroup group = new GoodsBrandGroup();
        BeanCopier.create(dto, group, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true)).copy();
        return group;
    }
}
