package quick.pager.shop.service.common;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.mapper.GoodsDetailMapper;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.goods.Goods;
import quick.pager.shop.goods.GoodsCart;

@Service
@Slf4j
public class CommonGoodsService {

    @Autowired
    private GoodsDetailMapper goodsDetailMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 购物车商品信息列表
     */
    public List<GoodsResponse> transGoods(List<GoodsCart> goodsCarts) {

        if (CollectionUtils.isEmpty(goodsCarts)) {
            return Lists.newArrayList();
        }

        List<GoodsResponse> goodsResponses = Lists.newArrayListWithCapacity(goodsCarts.size());
        goodsCarts.forEach(goodsCart -> {
            GoodsResponse goodsResponse = new GoodsResponse();
            goodsResponse.setGoodsDetail(goodsDetailMapper.selectByGoodsId(goodsCart.getGoodsId()));
            Goods goods = goodsMapper.selectByPrimaryKey(goodsCart.getGoodsId());
            goodsResponse.setBuyerGoodsCount(goodsCart.getGoodsCount());
            goodsResponse.setGoods(goods);
            goodsResponse.setSettlementAmount(goods.getGoodsDiscountAmount().multiply(new BigDecimal(goodsCart.getGoodsCount())));
            goodsResponses.add(goodsResponse);
        });

        return goodsResponses;
    }

    /**
     * 通过商品Id转换商品详细
     *
     * @param goodsId 商品id
     */
    public GoodsResponse transGoods(Long goodsId) {
        GoodsResponse goodsResponse = new GoodsResponse();
        goodsResponse.setGoods(goodsMapper.selectByPrimaryKey(goodsId));
        goodsResponse.setGoodsDetail(goodsDetailMapper.selectByGoodsId(goodsId));
        return goodsResponse;
    }
}
