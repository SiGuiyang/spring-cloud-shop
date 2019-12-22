package quick.pager.shop.manage.service.goods.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.goods.client.ClassificationClient;
import quick.pager.shop.goods.request.classification.GoodsClassificationRequest;
import quick.pager.shop.goods.request.classification.GoodsClassificationSaveRequest;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.manage.param.goods.ClassificationPageParam;
import quick.pager.shop.manage.param.goods.ClassificationSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.goods.GoodsClassService;
import quick.pager.shop.utils.BeanCopier;

@Service
public class GoodsClassServiceImpl implements GoodsClassService {

    @Autowired
    private ClassificationClient classificationClient;

    @Override
    public Response<List<GoodsClassificationResponse>> list(ClassificationPageParam param) {

        GoodsClassificationRequest request = new GoodsClassificationRequest();
        request.setClassName(param.getClassName());
        return classificationClient.list(request);
    }

    @Override
    public Response<Long> create(ClassificationSaveParam param) {
        GoodsClassificationSaveRequest request = new GoodsClassificationSaveRequest();
        BeanCopier.create(param, request).copy();
        return classificationClient.create(request);
    }

    @Override
    public Response<Long> modify(ClassificationSaveParam param) {
        GoodsClassificationSaveRequest request = new GoodsClassificationSaveRequest();
        BeanCopier.create(param, request).copy();
        return classificationClient.modify(request);
    }

    @Override
    public Response tree() {
        return null;
    }
}
