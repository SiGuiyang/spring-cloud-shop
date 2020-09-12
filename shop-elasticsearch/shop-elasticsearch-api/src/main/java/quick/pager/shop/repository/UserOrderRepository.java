package quick.pager.shop.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import quick.pager.shop.model.ESUserOrder;

public interface UserOrderRepository extends ElasticsearchRepository<ESUserOrder, Long> {
}
