package quick.pager.shop.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import quick.pager.shop.model.ESGoods;

/**
 * ES 商品
 *
 * @author siguiyang
 */
public interface GoodsRepository extends ElasticsearchRepository<ESGoods, Long> {
}
