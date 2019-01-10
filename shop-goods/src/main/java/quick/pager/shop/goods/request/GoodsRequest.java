package quick.pager.shop.goods.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsRequest extends Request {
    private static final long serialVersionUID = -3283409729233338177L;

    private String className;

    private String icon;

    private String createUser;
}
