package quick.pager.shop.service.impl;

import org.springframework.stereotype.Service;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.GoodsCartService;

@Service
public class GoodsCartServiceImpl implements GoodsCartService {

//    @Autowired
//    private GoodsClient goodsClient;

    @Override
    public Response goodsCarts() {

//        return goodsClient.goodsCarts(param.getUserId());
        return null;
    }

    @Override
    public Response modifyGoodsCart() {

//        return goodsClient.modifyGoodsCart(param.getUserId(),
//                Optional.ofNullable(param.getGoodsIds()).orElse(Collections.emptyList()).toArray(new Long[0]),
//                param.getGoodsCount(),
//                param.getEvent());
        return null;
    }
}
