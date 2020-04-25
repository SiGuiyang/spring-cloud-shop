package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.goods.mapper.GoodsClassMapper;
import quick.pager.shop.goods.mapper.GoodsSpuMapper;
import quick.pager.shop.goods.model.GoodsClass;
import quick.pager.shop.goods.model.GoodsSpu;
import quick.pager.shop.goods.request.spu.GoodsSpuPageRequest;
import quick.pager.shop.goods.request.spu.GoodsSpuSaveRequest;
import quick.pager.shop.goods.response.spu.GoodsSpuResponse;
import quick.pager.shop.goods.service.GoodsSpuService;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * <p>
 * 商品spu 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsSpuServiceImpl extends ServiceImpl<GoodsSpuMapper, GoodsSpu> implements GoodsSpuService {

    @Autowired
    private GoodsClassMapper goodsClassMapper;

    @Override
    public Response<Long> create(GoodsSpuSaveRequest request) {
        GoodsSpu spu = this.conv(request);
        spu.setCreateTime(DateUtils.dateTime());
        spu.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(spu);
        return new Response<>(spu.getId());
    }

    @Override
    public Response<Long> modify(GoodsSpuSaveRequest request) {
        GoodsSpu spu = this.conv(request);
        this.baseMapper.updateById(spu);
        return new Response<>(spu.getId());
    }

    @Override
    public Response<List<GoodsSpuResponse>> queryPage(GoodsSpuPageRequest request) {

        LambdaQueryWrapper<GoodsSpu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GoodsSpu::getDeleteStatus, Boolean.FALSE);

        if (StringUtils.isNotBlank(request.getSpuName())) {
            wrapper.likeRight(GoodsSpu::getSpuName, request.getSpuName());
        }
        Response<List<GoodsSpu>> response = this.toPage(request.getPage(), request.getPageSize(), wrapper);

        return Response.toResponse(response.getData().stream().map(this::conv).collect(Collectors.toList()), response.getTotal());
    }

    private GoodsSpu conv(GoodsSpuSaveRequest request) {
        GoodsSpu spu = new GoodsSpu();
        BeanCopier.create(request, spu).copy();
        return spu;
    }


    private GoodsSpuResponse conv(GoodsSpu spu) {
        GoodsSpuResponse response = new GoodsSpuResponse();
        BeanCopier.create(spu, response).copy();
        if (Objects.nonNull(spu.getClassificationId())) {
            GoodsClass goodsClass = goodsClassMapper.selectById(spu.getClassificationId());
            response.setClassificationName(Objects.nonNull(goodsClass) ? goodsClass.getClassName() : null);
        }
        return response;
    }

}
