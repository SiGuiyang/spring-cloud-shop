package quick.pager.shop.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import quick.pager.shop.model.ESSellerOrder;

public interface SellerOrderRepository extends ElasticsearchCrudRepository<ESSellerOrder, Long> {
}
