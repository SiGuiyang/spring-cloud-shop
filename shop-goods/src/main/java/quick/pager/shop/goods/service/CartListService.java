package quick.pager.shop.goods.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.feign.response.GoodsResponse;
import quick.pager.shop.goods.dto.CartDTO;
import quick.pager.shop.goods.mapper.GoodsCartMapper;
import quick.pager.shop.goods.service.common.CommonGoodsService;
import quick.pager.shop.model.goods.GoodsCart;

/**
 * 购物车列表服务
 */
@Service
@Slf4j
public class CartListService implements IService<List<GoodsResponse>> {

    @Autowired
    private GoodsCartMapper goodsCartMapper;

    @Autowired
    private CommonGoodsService commonGoodsService;

    @Override
    public Response<List<GoodsResponse>> doService(BaseDTO dto) {

        CartDTO cartDTO = (CartDTO) dto;

        List<GoodsCart> goodsCarts = goodsCartMapper.selectCarts(cartDTO.getUserId());

        List<GoodsResponse> goodsResponses = commonGoodsService.transGoods(goodsCarts);

        return new Response<>(goodsResponses);
    }
}
