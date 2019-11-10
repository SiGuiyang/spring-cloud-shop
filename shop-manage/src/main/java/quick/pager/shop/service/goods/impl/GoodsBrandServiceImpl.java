package quick.pager.shop.service.goods.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.goods.GoodsBrandClient;
import quick.pager.shop.dto.goods.GoodsBrandDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.goods.GoodsBrandService;

@Service
public class GoodsBrandServiceImpl implements GoodsBrandService {

    @Autowired
    private GoodsBrandClient goodsBrandClient;

    @Override
    public Response<List<GoodsBrandDTO>> list(GoodsBrandDTO dto) {
        return goodsBrandClient.list(dto);
    }

    @Override
    public Response create(GoodsBrandDTO dto) {
        return goodsBrandClient.create(dto);
    }

    @Override
    public Response modify(GoodsBrandDTO dto) {
        return goodsBrandClient.modify(dto);
    }
}
