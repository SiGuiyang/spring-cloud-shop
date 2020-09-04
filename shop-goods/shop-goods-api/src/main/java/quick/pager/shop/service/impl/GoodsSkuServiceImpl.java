package quick.pager.shop.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.mapper.GoodsSkuImageMapper;
import quick.pager.shop.mapper.GoodsSkuMapper;
import quick.pager.shop.model.Goods;
import quick.pager.shop.model.GoodsSku;
import quick.pager.shop.model.GoodsSkuImage;
import quick.pager.shop.goods.request.sku.GoodsSkuOtherRequest;
import quick.pager.shop.goods.request.sku.GoodsSkuPageRequest;
import quick.pager.shop.goods.request.sku.GoodsSkuSaveRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.service.GoodsSkuService;
import quick.pager.shop.model.ImageModel;
import quick.pager.shop.user.response.Response;
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

    private static final String SKU_PREFIX = "SKU";
    @Autowired
    private GoodsSkuImageMapper goodsSkuImageMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Response<Long> create(final GoodsSkuSaveRequest request) {
        GoodsSku sku = this.convert(request);
        sku.setCreateTime(DateUtils.dateTime());
        sku.setUpdateTime(DateUtils.dateTime());
        sku.setDeleteStatus(Boolean.FALSE);
        // 处理编码
        sku.setSkuCode(SKU_PREFIX + IdUtil.createSnowflake(1, 1).nextId());
        this.baseMapper.insert(sku);
        // 处理图片集
        if (CollectionUtils.isNotEmpty(request.getImages())) {

            GoodsSkuImage skuImage = new GoodsSkuImage();
            skuImage.setGoodsId(request.getGoodsId());
            skuImage.setSkuId(sku.getId());
            skuImage.setImages(JSON.toJSONString(request.getImages()));
            skuImage.setCreateUser(request.getCreateUser());
            skuImage.setUpdateUser(request.getUpdateUser());
            skuImage.setCreateTime(DateUtils.dateTime());
            skuImage.setUpdateTime(DateUtils.dateTime());
            skuImage.setDeleteStatus(Boolean.FALSE);
            goodsSkuImageMapper.insert(skuImage);
        }

        return new Response<>(sku.getId());
    }

    @Override
    public Response<Long> modify(final GoodsSkuSaveRequest request) {
        GoodsSku sku = this.convert(request);
        sku.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(sku);
        return new Response<>(sku.getId());
    }

    @Override
    public Response<List<GoodsSkuResponse>> queryPage(final GoodsSkuPageRequest request) {

        Response<List<GoodsSku>> page = this.toPage(request.getPage(), request.getPageSize(), new LambdaQueryWrapper<GoodsSku>()
                .eq(GoodsSku::getDeleteStatus, Boolean.FALSE)
                .likeRight(StringUtils.isNotBlank(request.getSkuName()), GoodsSku::getSkuName, request.getSkuName())
                .eq(StringUtils.isNotBlank(request.getSkuCode()), GoodsSku::getSkuCode, request.getSkuCode())
                .eq(Objects.nonNull(request.getInventory()), GoodsSku::getInventory, request.getInventory())
                .eq(Objects.nonNull(request.getDefaultSku()), GoodsSku::getDefaultSku, request.getDefaultSku())
                .orderByDesc(GoodsSku::getUpdateTime));
        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList())
                , page.getTotal());
    }

    @Override
    public Response<List<GoodsSkuResponse>> queryList(GoodsSkuOtherRequest request) {

        List<GoodsSku> skus = this.baseMapper.selectList(new LambdaQueryWrapper<GoodsSku>()
                .eq(GoodsSku::getDeleteStatus, Boolean.FALSE)
                .in(GoodsSku::getId, request.getIds())
                .orderByDesc(GoodsSku::getUpdateTime));

        return Response.toResponse(skus.stream().map(this::convert).collect(Collectors.toList()));
    }

    /**
     * GoodsSkuSaveRequest -> GoodsSku
     *
     * @param request 请求参数
     * @return goodsSku
     */
    private GoodsSku convert(GoodsSkuSaveRequest request) {
        GoodsSku sku = new GoodsSku();
        BeanCopier.create(request, sku).copy();
        return sku;
    }

    /**
     * GoodsSku -> GoodsSkuResponse
     *
     * @param sku sku商品
     * @return GoodsSkuResponse
     */
    private GoodsSkuResponse convert(GoodsSku sku) {
        GoodsSkuResponse response = new GoodsSkuResponse();
        BeanCopier.create(sku, response).copy();
        if (Objects.nonNull(sku.getGoodsId())) {
            Goods goods = goodsMapper.selectById(sku.getGoodsId());
            response.setGoodsId(sku.getGoodsId());
            response.setGoodsName(Objects.nonNull(goods) ? goods.getName() : null);
        }

        LambdaQueryWrapper<GoodsSkuImage> skuImageWrapper = new LambdaQueryWrapper<>();
        skuImageWrapper.eq(GoodsSkuImage::getDeleteStatus, Boolean.FALSE);
        skuImageWrapper.eq(GoodsSkuImage::getSkuId, sku.getId());
        skuImageWrapper.eq(GoodsSkuImage::getGoodsId, sku.getGoodsId());

        GoodsSkuImage skuImage = goodsSkuImageMapper.selectOne(skuImageWrapper);
        if (Objects.nonNull(skuImage)) {
            response.setImages(JSON.parseArray(skuImage.getImages(), ImageModel.class));
        }
        return response;
    }
}
