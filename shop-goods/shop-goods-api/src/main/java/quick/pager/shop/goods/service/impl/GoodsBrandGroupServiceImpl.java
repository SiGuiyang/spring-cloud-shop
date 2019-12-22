package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
//import quick.pager.shop.request.goods.GoodsBrandGroupDTO;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.goods.mapper.GoodsBrandGroupMapper;
import quick.pager.shop.goods.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.goods.service.GoodsBrandGroupService;
import quick.pager.shop.response.Response;

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
    public Response<List<GoodsBrandGroup>> groupList(GoodsBrandGroupPageRequest request) {
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
}
