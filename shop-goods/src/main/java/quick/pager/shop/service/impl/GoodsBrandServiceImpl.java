package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.dto.goods.GoodsBrandDTO;
import quick.pager.shop.mapper.GoodsBrandMapper;
import quick.pager.shop.model.goods.GoodsBrand;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsBrandService;

/**
 * 商品品牌
 *
 * @author siguiyang
 */
@Service
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandMapper, GoodsBrand> implements GoodsBrandService {
    @Override
    public Response<List<GoodsBrand>> goodsBrandList(GoodsBrandDTO dto) {
        QueryWrapper<GoodsBrand> qw = new QueryWrapper<>();
        qw.eq("delete_status", Boolean.FALSE);

        if (!StringUtils.isEmpty(dto.getBrandName())) {
            qw.likeRight("brand_name", dto.getBrandName());
        }

        if (!CollectionUtils.isEmpty(dto.getTimeRange())) {
            qw.ge("create_time", dto.getTimeRange().get(0));
            qw.le("create_time", dto.getTimeRange().get(1));
        }

        return this.toPage(dto.getPage(), dto.getPageSize(), qw);
    }
}
