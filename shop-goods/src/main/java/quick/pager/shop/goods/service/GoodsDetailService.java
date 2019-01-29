package quick.pager.shop.goods.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.feign.response.GoodsResponse;
import quick.pager.shop.goods.mapper.GoodsDetailMapper;
import quick.pager.shop.goods.mapper.GoodsMapper;
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
    public Response<GoodsResponse> doService(DTO dto) {

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
