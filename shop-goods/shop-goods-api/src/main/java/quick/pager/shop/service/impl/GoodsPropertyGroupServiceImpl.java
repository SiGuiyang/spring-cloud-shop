package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsPropertyGroupMapper;
import quick.pager.shop.model.GoodsPropertyGroup;
import quick.pager.shop.goods.request.property.group.GoodsPropertyGroupOtherRequest;
import quick.pager.shop.goods.request.property.group.GoodsPropertyGroupPageRequest;
import quick.pager.shop.goods.request.property.group.GoodsPropertyGroupSaveRequest;
import quick.pager.shop.goods.response.property.group.GoodsPropertyGroupResponse;
import quick.pager.shop.service.GoodsPropertyGroupService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * <p>
 * 商品属性组 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsPropertyGroupServiceImpl extends ServiceImpl<GoodsPropertyGroupMapper, GoodsPropertyGroup> implements GoodsPropertyGroupService {

    @Override
    public Response<List<GoodsPropertyGroupResponse>> queryPage(GoodsPropertyGroupPageRequest request) {

        Response<List<GoodsPropertyGroup>> page = this.toPage(request.getPage(), request.getPageSize(), new LambdaQueryWrapper<GoodsPropertyGroup>()
                .eq(GoodsPropertyGroup::getDeleteStatus, Boolean.FALSE)
                .likeRight(StringUtils.isNotBlank(request.getPropertyGroupName()), GoodsPropertyGroup::getPropertyGroupName, request.getPropertyGroupName())
                .orderByDesc(GoodsPropertyGroup::getUpdateTime));

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()), page.getTotal());
    }

    @Override
    public Response<List<GoodsPropertyGroupResponse>> queryList(GoodsPropertyGroupOtherRequest request) {

        LambdaQueryWrapper<GoodsPropertyGroup> wrapper = new LambdaQueryWrapper<GoodsPropertyGroup>()
                .eq(StringUtils.isNotBlank(request.getPropertyGroupName()), GoodsPropertyGroup::getDeleteStatus, Boolean.FALSE)
                .likeRight(GoodsPropertyGroup::getPropertyGroupName, request.getPropertyGroupName())
                .orderByDesc(GoodsPropertyGroup::getUpdateTime);

        List<GoodsPropertyGroup> goodsPropertyGroups = this.baseMapper.selectList(wrapper);

        return Response.toResponse(goodsPropertyGroups.stream().map(this::convert).collect(Collectors.toList()), 0L);
    }

    @Override
    public Response<Long> create(GoodsPropertyGroupSaveRequest request) {
        GoodsPropertyGroup group = this.convert(request);
        group.setDeleteStatus(Boolean.FALSE);
        group.setCreateTime(DateUtils.dateTime());
        group.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.insert(group);
        return new Response<>(group.getId());
    }

    @Override
    public Response<Long> modify(GoodsPropertyGroupSaveRequest request) {
        GoodsPropertyGroup group = this.convert(request);
        group.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(group);
        return new Response<>(group.getId());
    }

    /**
     * GoodsPropertyGroup -> GoodsPropertyGroupResponse
     *
     * @param group 属性组
     * @return 属性组
     */
    private GoodsPropertyGroupResponse convert(GoodsPropertyGroup group) {
        return BeanCopier.create(group, new GoodsPropertyGroupResponse()).copy();
    }

    /**
     * GoodsPropertyGroupSaveRequest -> GoodsPropertyGroup
     *
     * @param request 请求参数
     * @return 属性组
     */
    private GoodsPropertyGroup convert(GoodsPropertyGroupSaveRequest request) {
        return BeanCopier.create(request, new GoodsPropertyGroup()).copy();
    }
}
