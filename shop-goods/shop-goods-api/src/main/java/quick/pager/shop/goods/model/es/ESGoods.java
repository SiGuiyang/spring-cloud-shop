package quick.pager.shop.goods.model.es;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;
import quick.pager.shop.model.Model;

/**
 * ES商品
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Document(indexName = "es_goods", createIndex = false)
public class ESGoods extends Model {
    private static final long serialVersionUID = 8509683142547327975L;
}
