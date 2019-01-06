package quick.pager.shop.model.goods;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsDetail extends Model {
    private static final long serialVersionUID = 4774603647596393848L;

    private Long goodsId;

    private String goodsBanner;

    private String goodsDetails;
}