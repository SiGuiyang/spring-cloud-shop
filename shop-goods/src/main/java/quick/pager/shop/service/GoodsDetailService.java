package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.mapper.GoodsDetailMapper;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.model.goods.Goods;
import quick.pager.shop.model.goods.GoodsDetail;

/**
 * 商品详情服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class GoodsDetailService implements IService<GoodsResponse> {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsDetailMapper goodsDetailMapper;

    @Override
    public Response<GoodsResponse> doService(BaseDTO dto) {

        GoodsResponse goodsResponse = new GoodsResponse();

        Goods goods = goodsMapper.selectByPrimaryKey(dto.getId());
        if (ObjectUtils.isEmpty(goods)) {
            return new Response<>(goodsResponse);
        }

        if (goods.getDeleteStatus()) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.GOODS_EXPIRE);
        }

        GoodsDetail goodsDetail = goodsDetailMapper.selectByGoodsId(goods.getId());

        goodsResponse.setGoods(goods);
        goodsResponse.setGoodsDetail(goodsDetail);

        return new Response<>(goodsResponse);
    }
}
