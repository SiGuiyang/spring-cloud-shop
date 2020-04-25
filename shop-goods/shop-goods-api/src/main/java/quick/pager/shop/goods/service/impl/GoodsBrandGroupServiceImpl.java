package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import quick.pager.shop.goods.mapper.GoodsBrandGroupMapper;
import quick.pager.shop.goods.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupOtherRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandGroupResponse;
import quick.pager.shop.goods.service.GoodsBrandGroupService;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.impl.ServiceImpl;
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

        LambdaQueryWrapper<GoodsBrandGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GoodsBrandGroup::getDeleteStatus, Boolean.FALSE);
        if (StringUtils.isNotBlank(request.getBrandGroupName())) {
            wrapper.likeRight(GoodsBrandGroup::getBrandGroupName, request.getBrandGroupName());
        }

        if (CollectionUtils.isNotEmpty(request.getDateTimes())) {
            wrapper.ge(GoodsBrandGroup::getUpdateTime, request.getDateTimes().get(0));
            wrapper.le(GoodsBrandGroup::getUpdateTime, request.getDateTimes().get(1));
        }

        wrapper.orderByDesc(GoodsBrandGroup::getSequence);

        Response<List<GoodsBrandGroup>> response = this.toPage(request.getPage(), request.getPageSize(), wrapper);
        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }

    @Override
    public Response<List<GoodsBrandGroupResponse>> queryList(GoodsBrandGroupOtherRequest request) {
        LambdaQueryWrapper<GoodsBrandGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GoodsBrandGroup::getDeleteStatus, Boolean.FALSE);
        if (StringUtils.isNotBlank(request.getBrandGroupName())) {
            wrapper.likeRight(GoodsBrandGroup::getBrandGroupName, request.getBrandGroupName());
        }

        wrapper.orderByDesc(GoodsBrandGroup::getSequence);
        List<GoodsBrandGroup> brandGroups = this.baseMapper.selectList(wrapper);
        return Response.toResponse(brandGroups.stream().map(this::convert).collect(Collectors.toList()), 0L);
    }

    @Override
    public Response<Long> create(GoodsBrandGroupSaveRequest request) {
        GoodsBrandGroup group = convert(request);
        group.setCreateTime(DateUtils.dateTime());
        group.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(group);
        return new Response<>(group.getId());
    }

    @Override
    public Response<Long> modify(GoodsBrandGroupSaveRequest request) {
        GoodsBrandGroup group = convert(request);
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
