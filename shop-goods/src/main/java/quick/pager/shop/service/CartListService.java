package quick.pager.shop.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.CartDTO;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.mapper.GoodsCartMapper;
import quick.pager.shop.service.common.CommonGoodsService;
import quick.pager.shop.model.GoodsCart;

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
