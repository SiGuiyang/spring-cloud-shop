package quick.pager.shop.model.feign.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.ManageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderRequest extends ManageRequest {
    private static final long serialVersionUID = 3403409533500804139L;

    private String phone;

    private String orderCode;

    private String orderStatus;

    private Integer orderType;

}
