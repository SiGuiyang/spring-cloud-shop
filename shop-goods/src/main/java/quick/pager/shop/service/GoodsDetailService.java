package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.mapper.GoodsDetailMapper;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.goods.Goods;
import quick.pager.shop.goods.GoodsDetail;

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

        Response<GoodsResponse> response = new Response<>();

        GoodsResponse goodsResponse = new GoodsResponse();

        Goods goods = goodsMapper.selectByPrimaryKey(dto.getId());

        if (goods.getDeleteStatus()) {
            response.setCode(ResponseStatus.Code.FAIL_CODE);
            response.setMsg(ResponseStatus.GOODS_EXPIRE);
        }

        GoodsDetail goodsDetail = goodsDetailMapper.selectByGoodsId(goods.getId());

        goodsResponse.setGoods(goods);
        goodsResponse.setGoodsDetail(goodsDetail);

        response.setData(goodsResponse);

        return response;
    }
}
