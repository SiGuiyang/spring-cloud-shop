package quick.pager.shop.service.goods.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.GoodsClient;
import quick.pager.shop.dto.ClassificationDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.goods.ClassificationService;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    private GoodsClient goodsClient;

    @Override
    public Response classificationList(String className) {

        return goodsClient.classificationList(className);
    }

    @Override
    public Response modifyClassification(ClassificationDTO dto) {
        return goodsClient.modifyClassification(dto);
    }
}
