package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsDTO extends ManageDTO {
    private static final long serialVersionUID = -3283409729233338177L;

    private Long gcsId;

    private Long goodsDetailId;

    private Integer goodsStatus;

    private Integer goodsType;

    private String className;

    private String icon;

    private String createUser;

    private String goodsName;

    private String goodsCode;


}
