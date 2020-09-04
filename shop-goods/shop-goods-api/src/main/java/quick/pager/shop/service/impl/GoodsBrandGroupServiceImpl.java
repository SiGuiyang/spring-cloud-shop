package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsBrandGroupMapper;
import quick.pager.shop.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupOtherRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandGroupResponse;
import quick.pager.shop.service.GoodsBrandGroupService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * <p>
 * 品牌组 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsBrandGroupServiceImpl extends ServiceImpl<GoodsBrandGroupMapper, GoodsBrandGroup> implements GoodsBrandGroupService {

    @Override
    public Response<List<GoodsBrandGroupResponse>> queryPage(GoodsBrandGroupPageRequest request) {

        Response<List<GoodsBrandGroup>> response = this.toPage(request.getPage(), request.getPageSize(),  new LambdaQueryWrapper<GoodsBrandGroup>()
                .eq(GoodsBrandGroup::getDeleteStatus, Boolean.FALSE)
                .likeRight(StringUtils.isNotBlank(request.getBrandGroupName()), GoodsBrandGroup::getBrandGroupName, request.getBrandGroupName())
                .orderByDesc(GoodsBrandGroup::getSequence));

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }

    @Override
    public Response<List<GoodsBrandGroupResponse>> queryList(GoodsBrandGroupOtherRequest request) {
        LambdaQueryWrapper<GoodsBrandGroup> wrapper = new LambdaQueryWrapper<GoodsBrandGroup>()
                .eq(GoodsBrandGroup::getDeleteStatus, Boolean.FALSE)
                .likeRight(StringUtils.isNotBlank(request.getBrandGroupName()), GoodsBrandGroup::getBrandGroupName, request.getBrandGroupName())
                .orderByDesc(GoodsBrandGroup::getSequence);
        List<GoodsBrandGroup> brandGroups = this.baseMapper.selectList(wrapper);
        return Response.toResponse(brandGroups.stream().map(this::convert).collect(Collectors.toList()), 0L);
    }

    @Override
    public Response<Long> create(GoodsBrandGroupSaveRequest request) {
        GoodsBrandGroup group = convert(request);
        group.setCreateTime(DateUtils.dateTime());
        group.setUpdateTime(DateUtils.dateTime());
        group.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(group);
        return new Response<>(group.getId());
    }

    @Override
    public Response<Long> modify(GoodsBrandGroupSaveRequest request) {
        GoodsBrandGroup group = convert(request);
        group.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(group);

        return new Response<>(group.getId());
    }

    /**
     * GoodsBrandGroupSaveRequest -> GoodsBrandGroup
     */
    private GoodsBrandGroup convert(GoodsBrandGroupSaveRequest request) {
        return BeanCopier.create(request, new GoodsBrandGroup()).copy();
    }

    /**
     * GoodsBrandGroup -> GoodsBrandGroupResponse
     *
     * @param brandGroup 品牌组
     */
    private GoodsBrandGroupResponse convert(GoodsBrandGroup brandGroup) {
        return BeanCopier.create(brandGroup, new GoodsBrandGroupResponse()).copy();
    }
}
