package quick.pager.shop.service.goods.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.goods.ClassificationClient;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.goods.GoodsClassService;

@Service
public class GoodsClassServiceImpl implements GoodsClassService {

    @Autowired
    private ClassificationClient classificationClient;

    @Override
    public Response list(ClassificationDTO dto) {
        return classificationClient.list(dto);
    }

    @Override
    public Response create(ClassificationDTO dto) {
        return classificationClient.create(dto);
    }

    @Override
    public Response modify(ClassificationDTO dto) {
        return classificationClient.modify(dto);
    }

    @Override
    public Response tree() {
        return classificationClient.tree();
    }
}
