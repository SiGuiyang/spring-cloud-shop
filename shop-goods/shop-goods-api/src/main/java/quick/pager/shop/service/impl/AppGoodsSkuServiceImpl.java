package quick.pager.shop.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import quick.pager.shop.enums.SortEnums;
import quick.pager.shop.goods.field.GoodsField;
import quick.pager.shop.model.es.ESGoods;
import quick.pager.shop.param.GoodsSearchParam;
import quick.pager.shop.repository.GoodsRepository;
import quick.pager.shop.goods.response.GoodsResponse;
import quick.pager.shop.service.AppGoodsSkuService;
import quick.pager.shop.user.response.Response;

/**
 * @author siguiyang
 */
@Service
public class AppGoodsSkuServiceImpl implements AppGoodsSkuService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Response<List<GoodsResponse>> querySku(final GoodsSearchParam param) {

        BoolQueryBuilder builder = QueryBuilders.boolQuery();

        Sort sort = Sort.by(Sort.Direction.ASC, GoodsField.SKU_AMOUNT_KEY);

        if (Objects.nonNull(param.getSort())) {
            if (SortEnums.DESC.equals(param.getSort())) {
                sort = Sort.by(Sort.Direction.ASC, GoodsField.SKU_AMOUNT_KEY);
            }
        }

        // 搜索内容
        String keyword = param.getKeyword();

        builder.should(QueryBuilders.matchPhraseQuery("skuName", keyword).boost(100));
        builder.should(QueryBuilders.matchPhraseQuery("spuName", keyword).boost(90));
        builder.should(QueryBuilders.matchPhraseQuery("goodsName", keyword).boost(80));
        builder.should(QueryBuilders.matchPhraseQuery("goodsPropertyName", keyword).boost(70));
        builder.should(QueryBuilders.matchPhraseQuery("goodsPropertyGroupName", keyword).boost(60));
        builder.should(QueryBuilders.matchPhraseQuery("goodsBrandName", keyword).boost(50));
        builder.should(QueryBuilders.matchPhraseQuery("goodsBrandGroupName", keyword).boost(40));

        Page<ESGoods> page = goodsRepository.search(builder, PageRequest.of(param.getPage(), param.getPageSize(), sort));
        return Response.toResponse(page.getContent().stream().map(this::conv).collect(Collectors.toList()), page.getTotalElements());
    }

    /**
     * 商品转换
     */
    private GoodsResponse conv(ESGoods goods) {
        return null;
    }
}
