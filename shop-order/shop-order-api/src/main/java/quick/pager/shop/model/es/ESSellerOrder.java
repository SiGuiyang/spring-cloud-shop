package quick.pager.shop.model.es;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(indexName = "es_seller_order", createIndex = false)
public class ESSellerOrder extends Model {
    private static final long serialVersionUID = -4998360130097863880L;

    private Long ids;
}
