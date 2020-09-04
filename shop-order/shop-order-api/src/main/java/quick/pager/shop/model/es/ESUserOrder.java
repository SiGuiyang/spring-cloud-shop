package quick.pager.shop.model.es;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(indexName = "es_user_order", createIndex = false)
public class ESUserOrder extends Model {
    private static final long serialVersionUID = -4291580691749163266L;

    private Long ids;

}
