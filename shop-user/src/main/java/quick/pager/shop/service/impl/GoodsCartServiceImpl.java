package quick.pager.shop.service.impl;

import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.GoodsClient;
import quick.pager.shop.dto.GoodsCartDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsCartService;

@Service
public class GoodsCartServiceImpl implements GoodsCartService {

    @Autowired
    private GoodsClient goodsClient;

    @Override
    public Response goodsCarts(GoodsCartDTO dto) {

        return goodsClient.goodsCarts(dto.getUserId());
    }

    @Override
    public Response modifyGoodsCart(GoodsCartDTO dto) {

        return goodsClient.modifyGoodsCart(dto.getUserId(),
                Optional.ofNullable(dto.getGoodsIds()).orElse(Collections.emptyList()).toArray(new Long[0]),
                dto.getGoodsCount(),
                dto.getEvent());
    }
}
