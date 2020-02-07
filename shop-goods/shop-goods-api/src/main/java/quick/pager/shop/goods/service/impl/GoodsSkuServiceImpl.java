package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import quick.pager.shop.goods.mapper.GoodsSkuMapper;
import quick.pager.shop.goods.model.GoodsSku;
import quick.pager.shop.goods.model.GoodsSpu;
import quick.pager.shop.goods.request.sku.GoodsSkuPageRequest;
import quick.pager.shop.goods.request.sku.GoodsSkuSaveRequest;
import quick.pager.shop.goods.request.spu.GoodsSpuSaveRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.goods.response.spu.GoodsSpuResponse;
import quick.pager.shop.goods.service.GoodsSkuService;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * <p>
 * 商品sku 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsSkuServiceImpl extends ServiceImpl<GoodsSkuMapper, GoodsSku> implements GoodsSkuService {

    @Override
    public Response<Long> create(GoodsSkuSaveRequest request) {
        GoodsSku sku = this.conv(request);
        sku.setCreateTime(DateUtils.dateTime());
        sku.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(sku);
        return new Response<>(sku.getId());
    }

    @Override
    public Response<Long> modify(GoodsSkuSaveRequest request) {
        GoodsSku sku = this.conv(request);
        this.baseMapper.updateById(sku);
        return new Response<>(sku.getId());
    }

    @Override
    public Response<List<GoodsSkuResponse>> queryPage(GoodsSkuPageRequest request) {
        QueryWrapper<GoodsSku> qw = new QueryWrapper<>();

        Response<List<GoodsSku>> response = this.toPage(request.getPage(), request.getPageSize(), qw);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::conv).collect(Collectors.toList())
                , response.getTotal());
    }

    private GoodsSku conv(GoodsSkuSaveRequest request) {
        GoodsSku sku = new GoodsSku();
        BeanCopier.create(request, sku).copy();
        return sku;
    }

    private GoodsSkuResponse conv(GoodsSku sku) {
        GoodsSkuResponse response = new GoodsSkuResponse();
        BeanCopier.create(sku, response).copy();
        return response;
    }
}
