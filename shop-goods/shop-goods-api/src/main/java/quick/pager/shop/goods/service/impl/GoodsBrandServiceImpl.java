package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.goods.mapper.GoodsBrandMapper;
import quick.pager.shop.goods.model.GoodsBrand;
import quick.pager.shop.goods.request.brand.GoodsBrandPageRequest;
import quick.pager.shop.goods.service.GoodsBrandService;
import quick.pager.shop.response.Response;

/**
 * 商品品牌
 *
 * @author siguiyang
 */
@Service
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandMapper, GoodsBrand> implements GoodsBrandService {

    @Override
    public Response<List<GoodsBrand>> goodsBrandList(GoodsBrandPageRequest request) {
        QueryWrapper<GoodsBrand> qw = new QueryWrapper<>();
        qw.eq("delete_status", Boolean.FALSE);

        if (!StringUtils.isEmpty(request.getBrandName())) {
            qw.likeRight("brand_name", request.getBrandName());
        }

        if (!CollectionUtils.isEmpty(request.getDateTimes())) {
            qw.ge("create_time", request.getDateTimes().get(0));
            qw.le("create_time", request.getDateTimes().get(1));
        }

        return this.toPage(request.getPage(), request.getPageSize(), qw);
    }
}
