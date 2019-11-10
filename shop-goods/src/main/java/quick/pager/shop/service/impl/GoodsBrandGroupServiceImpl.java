package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.dto.goods.GoodsBrandGroupDTO;
import quick.pager.shop.mapper.GoodsBrandGroupMapper;
import quick.pager.shop.model.goods.GoodsBrandGroup;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsBrandGroupService;

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
    public Response<List<GoodsBrandGroup>> groupList(GoodsBrandGroupDTO dto) {
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

        return this.toPage(dto.getPage(), dto.getPageSize(), qw);
    }
}
