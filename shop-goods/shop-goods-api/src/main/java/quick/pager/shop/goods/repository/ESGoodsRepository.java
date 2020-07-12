package quick.pager.shop.goods.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import quick.pager.shop.goods.model.es.ESGoods;

/**
 * ES 商品
 *
 * @author siguiyang
 */
public interface ESGoodsRepository extends ElasticsearchRepository<ESGoods, Long> {
}
