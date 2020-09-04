package quick.pager.shop.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import quick.pager.shop.model.es.ESUserOrder;

public interface UserOrderRepository extends ElasticsearchRepository<ESUserOrder, Long> {
}
