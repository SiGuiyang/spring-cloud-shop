package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsCartMapper;
import quick.pager.shop.model.GoodsCart;
import quick.pager.shop.param.CartParam;
import quick.pager.shop.cart.response.GoodsCartDetailResponse;
import quick.pager.shop.cart.response.GoodsCartResponse;
import quick.pager.shop.service.CartService;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.client.GoodsSkuClient;
import quick.pager.shop.goods.request.sku.GoodsSkuOtherRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.model.ImageModel;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.seller.client.SellerClient;
import quick.pager.shop.response.SellerInfoResponse;
import quick.pager.shop.utils.DateUtils;

/**
 * CartServiceImpl
 *
 * @author siguiyang
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private GoodsCartMapper goodsCartMapper;
    @Autowired
    private SellerClient sellerClient;
    @Autowired
    private GoodsSkuClient goodsSkuClient;

    @Override
    public Response<List<GoodsCartResponse>> list(final Long userId, final Integer page) {
        LambdaQueryWrapper<GoodsCart> wrapper = new LambdaQueryWrapper<GoodsCart>()
                .eq(GoodsCart::getDeleteStatus, Boolean.FALSE)
                .eq(GoodsCart::getUserId, userId);

        Integer total = goodsCartMapper.selectCount(wrapper);

        List<GoodsCartResponse> result = Lists.newArrayList();

        if (total > IConsts.ZERO) {
            List<GoodsCart> goodsCarts = goodsCartMapper.selectPage(new Page<>(page, IConsts.TEN, Boolean.FALSE), wrapper).getRecords();

            Map<Long, List<GoodsCart>> listMap = goodsCarts.stream().collect(Collectors.groupingBy(GoodsCart::getSellerId));

            listMap.forEach((k, v) -> {
                GoodsCartResponse goodsCart = new GoodsCartResponse();
                goodsCart.setId(k);
                // 1. 处理商户
                Response<SellerInfoResponse> sellerInfoResp = sellerClient.querySeller(k);
                if (ResponseStatus.Code.SUCCESS == sellerInfoResp.getCode()) {
                    goodsCart.setName(sellerInfoResp.getData().getSellerName());
                    goodsCart.setLogo(sellerInfoResp.getData().getLogo());
                }
                // 2. 处理购物车商品
                List<Long> skuIds = v.stream().map(GoodsCart::getSkuId).collect(Collectors.toList());
                GoodsSkuOtherRequest skuOtherReq = new GoodsSkuOtherRequest();
                skuOtherReq.setIds(skuIds);
                Response<List<GoodsSkuResponse>> skuOtherRes = goodsSkuClient.queryList(skuOtherReq);
                if (ResponseStatus.Code.SUCCESS == skuOtherRes.getCode()) {
                    goodsCart.setDetails(skuOtherRes.getData().stream().map(item -> {
                        GoodsCartDetailResponse goodsCartDetail = new GoodsCartDetailResponse();
                        goodsCartDetail.setSkuId(item.getId());
                        goodsCartDetail.setSkuName(item.getSkuName());
                        item.getImages().stream()
                                .filter(ImageModel::getMaster)
                                .findFirst()
                                .ifPresent(it -> goodsCartDetail.setSkuLogo(it.getUrl()));

                        v.stream()
                                .filter(it -> IConsts.ZERO == item.getId().compareTo(it.getSkuId()))
                                .findFirst()
                                .ifPresent(it -> {
                                    goodsCartDetail.setQuantity(it.getQuantity());
                                    goodsCartDetail.setGoodsCartId(it.getId());
                                    goodsCartDetail.setSkuAmount(item.getSkuAmount().multiply(new BigDecimal(it.getQuantity())));
                                });
                        return goodsCartDetail;
                    }).collect(Collectors.toList()));
                }
            });
        }

        return Response.toResponse(result, total);
    }

    @Override
    public Response<String> add(final CartParam param) {

        final Long id = param.getId();
        final Long skuId = param.getSkuId();
        final Integer quantity = param.getQuantity();
        final Long userId = param.getUserId();
        final Long sellerId = param.getSellerId();

        // 购物车的主键不存在，则认为是新增的购物车条目
        // 有一种情况，是在商品详情页时，重复添加购物车，此时前端获取不到购物车的主键
        // 则，后端需要重新处理
        if (Objects.isNull(id)) {

            List<GoodsCart> goodsCarts = goodsCartMapper.selectList(new LambdaQueryWrapper<GoodsCart>()
                    .eq(GoodsCart::getDeleteStatus, Boolean.FALSE)
                    .eq(GoodsCart::getUserId, userId)
                    .eq(GoodsCart::getSkuId, skuId));
            if (CollectionUtils.isEmpty(goodsCarts)) {
                GoodsCart goodsCart = new GoodsCart();
                goodsCart.setUserId(userId);
                goodsCart.setSkuId(skuId);
                goodsCart.setQuantity(quantity);
                goodsCart.setSellerId(sellerId);
                goodsCart.setUpdateTime(DateUtils.dateTime());
                goodsCart.setCreateTime(DateUtils.dateTime());
                goodsCart.setDeleteStatus(Boolean.FALSE);
                goodsCartMapper.insert(goodsCart);
            } else {
                // 此时这种情况，需要更新购物车的数量
                goodsCarts.forEach(goodsCart -> {
                    GoodsCart updateGoodsCart = new GoodsCart();
                    updateGoodsCart.setId(goodsCart.getId());
                    updateGoodsCart.setQuantity(quantity + goodsCart.getQuantity());
                    updateGoodsCart.setUpdateTime(DateUtils.dateTime());
                    goodsCartMapper.updateById(goodsCart);
                });
            }
        } else {
            GoodsCart goodsCart = new GoodsCart();
            goodsCart.setId(id);
            goodsCart.setQuantity(quantity);
            goodsCart.setUpdateTime(DateUtils.dateTime());
            goodsCartMapper.updateById(goodsCart);
        }

        return new Response<>();
    }

    @Override
    public Response<String> delete(final List<Long> ids) {

        GoodsCart goodsCart = new GoodsCart();
        goodsCart.setDeleteStatus(Boolean.TRUE);
        goodsCart.setUpdateTime(DateUtils.dateTime());
        goodsCartMapper.update(goodsCart, new LambdaQueryWrapper<GoodsCart>().in(GoodsCart::getId, ids));
        return Response.toResponse("删除成功");
    }
}
