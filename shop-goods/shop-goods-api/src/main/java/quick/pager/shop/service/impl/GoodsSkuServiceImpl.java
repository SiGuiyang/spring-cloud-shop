package quick.pager.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.goods.dto.UploadDTO;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.mapper.GoodsSkuImageMapper;
import quick.pager.shop.mapper.GoodsSkuMapper;
import quick.pager.shop.mapper.GoodsSkuStockMapper;
import quick.pager.shop.model.Goods;
import quick.pager.shop.model.GoodsSku;
import quick.pager.shop.goods.request.sku.GoodsSkuOtherRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.model.GoodsSkuImage;
import quick.pager.shop.model.GoodsSkuStock;
import quick.pager.shop.service.GoodsSkuService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;

/**
 * <p>
 * 商品sku 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
@Slf4j
public class GoodsSkuServiceImpl extends ServiceImpl<GoodsSkuMapper, GoodsSku> implements GoodsSkuService {

    @Autowired
    private GoodsSkuImageMapper goodsSkuImageMapper;
    @Autowired
    private GoodsSkuStockMapper goodsSkuStockMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Response<List<GoodsSkuResponse>> queryList(final GoodsSkuOtherRequest request) {

        List<GoodsSku> goodsSkus = this.baseMapper.selectList(new LambdaQueryWrapper<GoodsSku>()
                .in(CollectionUtils.isNotEmpty(request.getIds()), GoodsSku::getId, request.getIds()));

        return Response.toResponse(goodsSkus.stream().map(this::convert).collect(Collectors.toList()));
    }

    @Override
    public Response<GoodsSkuResponse> querySku(final Long skuId, final String skuCode) {

        List<GoodsSku> goodsSkus = this.baseMapper.selectList(new LambdaQueryWrapper<GoodsSku>()
                .eq(Objects.nonNull(skuId), GoodsSku::getId, skuId)
                .eq(StringUtils.isNotEmpty(skuCode), GoodsSku::getSkuCode, skuCode));

        Assert.isTrue(goodsSkus.size() > 1, () -> "商品数据不正确");

        return Response.toResponse(convert(goodsSkus.get(IConsts.ZERO)));
    }

    /**
     * sku -> goodsSkuResponse
     *
     * @param item 商品sku
     */
    private GoodsSkuResponse convert(final GoodsSku item) {
        GoodsSkuResponse sku = new GoodsSkuResponse();
        sku.setId(item.getId());
        sku.setGoodsId(item.getGoodsId());
        sku.setSkuName(item.getSkuName());
        sku.setSkuCode(item.getSkuCode());
        sku.setState(item.getState());
        sku.setWeight(item.getWeight());
        sku.setSkuAmount(item.getSkuAmount());
        sku.setDiscountAmount(item.getDiscountAmount());
        sku.setDefaultSku(item.getDeleteStatus());
        sku.setDescription(item.getDescription());
        // sku图片
        GoodsSkuImage skuImage = this.goodsSkuImageMapper.selectOne(new LambdaQueryWrapper<GoodsSkuImage>()
                .eq(GoodsSkuImage::getSkuId, item.getId()));
        if (Objects.nonNull(skuImage)) {
            sku.setImages(JSON.parseArray(skuImage.getImages(), UploadDTO.class));
        }

        // sku 库存
        GoodsSkuStock stock = this.goodsSkuStockMapper.selectOne(new LambdaQueryWrapper<GoodsSkuStock>()
                .eq(GoodsSkuStock::getSkuId, item.getId()));
        if (Objects.nonNull(stock)) {
            sku.setStock(stock.getStock());
        }

        // 处理商品是否过期
        Goods goods = this.goodsMapper.selectById(item.getGoodsId());

        // 已过期
        if (Objects.nonNull(goods) && goods.getEndTime().isBefore(LocalDate.now())) {
            sku.setExpire(Boolean.TRUE);
        }
        return sku;
    }
}
