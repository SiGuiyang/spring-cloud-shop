package quick.pager.shop.manage.service.goods.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.manage.param.goods.GoodsPageParam;
import quick.pager.shop.manage.param.goods.GoodsSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.goods.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

//    @Autowired
//    private GoodsClient goodsClient;
//    @Autowired
//    private ActivityClient activityClient;

    @Override
    public Response queryGoodsList(GoodsPageParam param) {
//        Response<List<Goods>> listResponse = goodsClient.queryGoodsList(param);
//
//        if (null != param.getActivityId()
//                && 0L != param.getActivityId()
//                && ResponseStatus.Code.SUCCESS == listResponse.getCode()) {
//
//            List<Goods> data = listResponse.getData();
//            Optional.ofNullable(data).orElse(Collections.emptyList()).forEach(goods -> {
//                Response response = activityClient.queryFightGroupGoods(param.getActivityId(), goods.getId());
//
//                if (ResponseStatus.Code.SUCCESS == response.getCode()) {
//                    goods.setJoin(true);
//                }
//            });
//
//        }
        return null;
    }

    @Override
    public Response addGoods(GoodsSaveParam param) {
//        return goodsClient.addGoods(param);
        return null;
    }

    @Override
    public Response modifyGoods(GoodsSaveParam param) {
//        return goodsClient.modifyGoods(param);
        return null;
    }

    @Override
    public Response goodsInfo(Long goodsId) {
//        return goodsClient.goodsInfo(goodsId);
        return null;
    }
}
