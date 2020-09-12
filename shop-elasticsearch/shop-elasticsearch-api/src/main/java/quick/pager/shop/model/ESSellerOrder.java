package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(indexName = "es_seller_order", createIndex = false)
public class ESSellerOrder extends Model {
    private static final long serialVersionUID = -4998360130097863880L;

    private Long ids;
}
