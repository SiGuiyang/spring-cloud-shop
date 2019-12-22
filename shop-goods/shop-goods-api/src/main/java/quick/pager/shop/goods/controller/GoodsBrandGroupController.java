package quick.pager.shop.goods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.goods.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupSaveRequest;
import quick.pager.shop.goods.service.GoodsBrandGroupService;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 商品品牌组
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.GOODS)
public class GoodsBrandGroupController {

    @Autowired
    private GoodsBrandGroupService goodsBrandGroupService;

    /**
     * 新建商品品牌组
     */
    @PostMapping("/brand/group/create")
    public Response create(@RequestBody GoodsBrandGroupSaveRequest request) {
        GoodsBrandGroup group = convert(request);
        group.setCreateTime(DateUtils.dateTime());
        group.setDeleteStatus(Boolean.FALSE);
        goodsBrandGroupService.save(group);
        return new Response();
    }

    /**
     * 修改商品品牌组
     */
    @PostMapping("/brand/group/modify")
    public Response modify(@RequestBody GoodsBrandGroupSaveRequest param) {
        GoodsBrandGroup group = convert(param);
        goodsBrandGroupService.updateById(group);
        return new Response();
    }

    /**
     * 商品品牌组列表
     */
    @PostMapping("/brand/group/list")
    public Response<List<GoodsBrandGroup>> list(@RequestBody GoodsBrandGroupPageRequest request) {
        return goodsBrandGroupService.groupList(request);
    }

    /**
     * 商品品牌组所有列表
     */
    @PostMapping("/brand/group/listAll")
    public Response<List<GoodsBrandGroup>> listAll() {
        QueryWrapper<GoodsBrandGroup> qw = new QueryWrapper<>();
        qw.eq("delete_status", Boolean.FALSE);
        return Response.toResponse(goodsBrandGroupService.list(qw), 0);
    }

    /**
     * DTO -> db model
     */
    private GoodsBrandGroup convert(GoodsBrandGroupSaveRequest request) {
        GoodsBrandGroup group = new GoodsBrandGroup();
        BeanCopier.create(request, group).copy();
        return group;
    }
}
