package quick.pager.shop.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.CartDTO;
import quick.pager.shop.model.goods.GoodsCart;
import quick.pager.shop.response.Response;
import quick.pager.shop.mapper.GoodsCartMapper;
import quick.pager.shop.utils.DateUtils;

/**
 * 购物车添加删除服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class CartModifyService implements IService {

    @Autowired
    private GoodsCartMapper goodsCartMapper;

    @Override
    public Response doService(BaseDTO dto) {

        CartDTO cartDTO = (CartDTO) dto;

        String event = cartDTO.getEvent();
        Response response = null;

        if (Constants.Event.ADD.equals(event)) {
            response = addGoodsCart(cartDTO.getUserId(), cartDTO.getGoodsCount(), cartDTO.getGoodsIds());
        } else if (Constants.Event.DELETE.equals(event)) {
            response = deleteGoodsCart(cartDTO.getUserId(), cartDTO.getGoodsIds());
        }

        return response;
    }

    /**
     * 添加商品入购物车
     *
     * @param userId     用户Id
     * @param goodsCount 商品数量
     * @param goodsIds   商品
     */
    private Response addGoodsCart(Long userId, Integer goodsCount, List<Long> goodsIds) {

        GoodsCart goodsCart = new GoodsCart();
        goodsCart.setGoodsCount(goodsCount);
        goodsCart.setUserId(userId);
        goodsCart.setGoodsId(goodsIds.get(0));
        goodsCart.setCreateTime(DateUtils.now());
        goodsCart.setDeleteStatus(false);
        goodsCartMapper.insertSelective(goodsCart);

        return new Response();

    }

    private Response deleteGoodsCart(Long userId, List<Long> goodsIds) {


        List<GoodsCart> goodsCarts = goodsCartMapper.selectGoodsCarts(userId, goodsIds);

        List<Long> collect = Optional.ofNullable(goodsCarts).orElse(Collections.emptyList()).stream().map(GoodsCart::getId).collect(Collectors.toList());

        collect.forEach(id -> {
            GoodsCart goodsCart = new GoodsCart();
            goodsCart.setId(id);
            goodsCart.setDeleteStatus(true);
            goodsCartMapper.updateByPrimaryKeySelective(goodsCart);
        });

        return new Response();
    }
}
