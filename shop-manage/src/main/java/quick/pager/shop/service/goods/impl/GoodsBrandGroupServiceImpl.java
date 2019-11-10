package quick.pager.shop.service.goods.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.goods.GoodsBrandGroupClient;
import quick.pager.shop.dto.goods.GoodsBrandGroupDTO;
import quick.pager.shop.model.goods.GoodsBrandGroup;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsBrandGroupService;

@Service
public class GoodsBrandGroupServiceImpl implements GoodsBrandGroupService {

    @Autowired
    private GoodsBrandGroupClient goodsBrandGroupClient;

    @Override
    public Response<List<GoodsBrandGroup>> list(GoodsBrandGroupDTO dto) {
        return goodsBrandGroupClient.list(dto);
    }

    @Override
    public Response create(GoodsBrandGroupDTO dto) {
        return goodsBrandGroupClient.create(dto);
    }

    @Override
    public Response modify(GoodsBrandGroupDTO dto) {
        return goodsBrandGroupClient.modify(dto);
    }

    @Override
    public Response<List<GoodsBrandGroup>> listAll() {
        return goodsBrandGroupClient.listAll();
    }
}
