package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.goods.mapper.GoodsBrandGroupMapper;
import quick.pager.shop.goods.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupSaveRequest;
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
    public Response<List<GoodsBrandGroup>> queryPage(GoodsBrandGroupPageRequest request) {
        QueryWrapper<GoodsBrandGroup> qw = new QueryWrapper<>();

        qw.eq("delete_status", Boolean.FALSE);

        if (!StringUtils.isEmpty(request.getBrandGroupName())) {
            qw.likeRight("brand_group_name", request.getBrandGroupName());
        }

        if (!CollectionUtils.isEmpty(request.getDateTimes())) {
            qw.ge("create_time", request.getDateTimes().get(0));
            qw.le("create_time", request.getDateTimes().get(1));
        }

        qw.orderByDesc("sequence");

        return this.toPage(request.getPage(), request.getPageSize(), qw);
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
     * DTO -> db model
     */
    private GoodsBrandGroup convert(GoodsBrandGroupSaveRequest request) {
        GoodsBrandGroup group = new GoodsBrandGroup();
        BeanCopier.create(request, group).copy();
        return group;
    }
}
