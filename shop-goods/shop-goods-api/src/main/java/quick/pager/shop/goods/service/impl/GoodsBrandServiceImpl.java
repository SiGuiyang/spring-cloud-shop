package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.goods.mapper.GoodsBrandMapper;
import quick.pager.shop.goods.model.GoodsBrand;
import quick.pager.shop.goods.request.brand.GoodsBrandPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandSaveRequest;
import quick.pager.shop.goods.service.GoodsBrandService;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

@Service
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandMapper, GoodsBrand> implements GoodsBrandService {

    @Override
    public Response<List<GoodsBrand>> queryPage(GoodsBrandPageRequest request) {
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


    @Override
    public Response<Long> create(GoodsBrandSaveRequest request) {
        GoodsBrand brand = this.convert(request);
        brand.setDeleteStatus(Boolean.FALSE);
        brand.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(brand);
        return new Response<>(brand.getId());
    }

    @Override
    public Response<Long> modify(GoodsBrandSaveRequest request) {
        GoodsBrand brand = this.convert(request);
        this.baseMapper.updateById(brand);
        return new Response<>(brand.getId());
    }


    /**
     * request -> db model
     */
    private GoodsBrand convert(GoodsBrandSaveRequest request) {
        GoodsBrand brand = new GoodsBrand();
        BeanCopier.create(request, brand).copy();
        return brand;
    }
}
