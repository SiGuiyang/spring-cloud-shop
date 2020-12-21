package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quick.pager.shop.cart.constants.CartRedisKeys;
import quick.pager.shop.cart.request.CartOtherRequest;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.client.GoodsSkuClient;
import quick.pager.shop.goods.request.sku.GoodsSkuOtherRequest;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.mapper.GoodsCartMapper;
import quick.pager.shop.model.GoodsCart;
import quick.pager.shop.cart.request.CartRequest;
import quick.pager.shop.cart.response.GoodsCartResponse;
import quick.pager.shop.service.CartService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;
import quick.pager.shop.utils.DateUtils;

/**
 * CartServiceImpl
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private GoodsCartMapper goodsCartMapper;
    @Autowired
    private GoodsSkuClient goodsSkuClient;
    @Autowired
    private RedissonClient redissonClient;
    @Value("${spring.profiles.active}")
    private String env;


    @Override
    public Response<List<GoodsCartResponse>> page(final Long userId, final Integer page) {

        LambdaQueryWrapper<GoodsCart> wrapper = new LambdaQueryWrapper<GoodsCart>()
                .eq(GoodsCart::getDeleteStatus, Boolean.FALSE)
                .eq(GoodsCart::getUserId, userId);

        Integer total = goodsCartMapper.selectCount(wrapper);

        List<GoodsCartResponse> result = Lists.newArrayList();

        if (total > IConsts.ZERO) {
            List<GoodsCart> goodsCarts = goodsCartMapper.selectPage(new Page<>(page, IConsts.TEN, Boolean.FALSE), wrapper).getRecords();
            result = this.convert(goodsCarts);
        }

        return Response.toResponse(result, total);
    }

    @Override
    public Response<List<GoodsCartResponse>> list(final CartOtherRequest request) {

        List<GoodsCart> goodsCarts = goodsCartMapper.selectList(new LambdaQueryWrapper<GoodsCart>()
                .in(CollectionUtils.isNotEmpty(request.getGoodsCartIds()), GoodsCart::getId, request.getGoodsCartIds()));

        return Response.toResponse(this.convert(goodsCarts));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<Long> create(final CartRequest request) {

        final String key = env.concat(CartRedisKeys.APP_GOODS_CART_ADD_PREFIX)
                .concat(String.valueOf(request.getUserId()))
                .concat(":").concat(String.valueOf(request.getSkuId()));
        RLock lock = redissonClient.getLock(key);
        try {
            if (lock.tryLock(300, TimeUnit.MILLISECONDS)) {
                GoodsCart goodsCart = this.goodsCartMapper.selectOne(new LambdaQueryWrapper<GoodsCart>()
                        .eq(GoodsCart::getUserId, request.getUserId())
                        .eq(GoodsCart::getSkuId, request.getSkuId()));


                if (Objects.isNull(goodsCart)) {
                    goodsCart = new GoodsCart();
                    goodsCart.setUserId(request.getUserId());
                    goodsCart.setSkuId(request.getSkuId());
                    goodsCart.setQuantity(IConsts.ONE);
                    goodsCart.setSellerId(request.getSellerId());
                    goodsCart.setUpdateTime(DateUtils.dateTime());
                    goodsCart.setCreateTime(DateUtils.dateTime());
                    goodsCart.setDeleteStatus(Boolean.FALSE);
                    Assert.isTrue(this.goodsCartMapper.insert(goodsCart) > 0, () -> "添加购物车失败");
                } else {
                    GoodsCart updateGoodsCart = new GoodsCart();
                    updateGoodsCart.setId(goodsCart.getId());
                    updateGoodsCart.setQuantity(goodsCart.getQuantity() + IConsts.ONE);
                    updateGoodsCart.setUpdateTime(DateUtils.dateTime());
                    Assert.isTrue(this.goodsCartMapper.updateById(updateGoodsCart) > 0, () -> "添加购物车失败");
                }
            } else {
                return Response.toError(ResponseStatus.Code.FAIL_CODE, "您操作太快，请稍后重试");
            }
        } catch (InterruptedException e) {
            log.error("添加购物车加锁失败 userId = {}, skuId = {}", request.getUserId(), request.getSkuId());
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(lock) && lock.isLocked()) {
                lock.unlock();
            }
        }

        return Response.toResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<Long> delete(final Long id) {

        GoodsCart goodsCart = this.goodsCartMapper.selectById(id);
        Assert.isTrue(Objects.nonNull(goodsCart), () -> "当前购物车栏不存在");

        int delete = this.goodsCartMapper.deleteById(id);

        Assert.isTrue(delete > 0, () -> "删除购物车失败");
        return Response.toResponse(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<List<Long>> deleteBatch(final List<Long> ids) {
        int delete = goodsCartMapper.deleteBatchIds(ids);
        Assert.isTrue(delete > 0, () -> "删除购物车失败");
        return Response.toResponse(ids);
    }


    /**
     * 数据转换
     *
     * @param goodsCarts 商品购物车信息
     */
    private List<GoodsCartResponse> convert(final List<GoodsCart> goodsCarts) {
        //1. 从商品服务查询商品sku信息
        GoodsSkuOtherRequest skuOtherReq = new GoodsSkuOtherRequest();
        skuOtherReq.setIds(goodsCarts.stream().map(GoodsCart::getSkuId).collect(Collectors.toList()));
        Response<List<GoodsSkuResponse>> skuOtherRes = goodsSkuClient.queryList(skuOtherReq);
        Map<Long, List<GoodsSkuResponse>> skuMap = Maps.newHashMap();
        if (skuOtherRes.check()) {
            skuMap.putAll(skuOtherRes.getData().stream().collect(Collectors.groupingBy(GoodsSkuResponse::getId)));
        }

        return goodsCarts.stream().map(item -> {
            GoodsCartResponse goodsCart = new GoodsCartResponse();
            goodsCart.setId(item.getId());
            goodsCart.setQuantity(item.getQuantity());
            goodsCart.setSkuId(item.getSkuId());
            skuMap.get(item.getSkuId()).stream().findFirst().ifPresent(sku -> {
                goodsCart.setSkuName(sku.getSkuName());
                goodsCart.setSkuImage(sku.getImages().get(0).getUrl());
                goodsCart.setExpire(sku.getExpire());
                goodsCart.setDiscountAmount(sku.getDiscountAmount());
                goodsCart.setSkuAmount(sku.getSkuAmount());
            });
            return goodsCart;
        }).collect(Collectors.toList());
    }
}
