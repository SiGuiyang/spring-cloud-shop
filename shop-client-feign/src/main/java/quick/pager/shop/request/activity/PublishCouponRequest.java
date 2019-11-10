package quick.pager.shop.request.activity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class PublishCouponRequest extends ManageDTO {
    private static final long serialVersionUID = 1890447832247125669L;

    private String file;
    private Long templateId;
}
