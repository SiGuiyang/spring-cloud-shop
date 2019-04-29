package quick.pager.shop.service.goods.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.client.GoodsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.GoodsDTO;
import quick.pager.shop.model.Goods;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.goods.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsClient goodsClient;
    @Autowired
    private ActivityClient activityClient;

    @Override
    public Response queryGoodsList(GoodsDTO request) {
        Response<List<Goods>> listResponse = goodsClient.queryGoodsList(request);

        if (null != request.getActivityId()
                && 0L != request.getActivityId()
                && ResponseStatus.Code.SUCCESS == listResponse.getCode()) {

            List<Goods> data = listResponse.getData();
            Optional.ofNullable(data).orElse(Collections.emptyList()).forEach(goods -> {
                Response response = activityClient.queryFightGroupGoods(request.getActivityId(), goods.getId());

                if (ResponseStatus.Code.SUCCESS == response.getCode()) {
                    goods.setJoin(true);
                }
            });

        }
        return listResponse;
    }

    @Override
    public Response addGoods(GoodsDTO request) {
        return goodsClient.addGoods(request);
    }

    @Override
    public Response modifyGoods(GoodsDTO request) {
        return goodsClient.modifyGoods(request);
    }

    @Override
    public Response goodsInfo(Long goodsId) {
        return goodsClient.goodsInfo(goodsId);
    }
}
