package quick.pager.shop.goods.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsDTO extends Request {
    private static final long serialVersionUID = -3283409729233338177L;

    private String className;

    private String icon;

    private String createUser;
}
