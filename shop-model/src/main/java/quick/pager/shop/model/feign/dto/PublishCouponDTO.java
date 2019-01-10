package quick.pager.shop.model.feign.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class PublishCouponDTO extends DTO{
    private static final long serialVersionUID = 1890447832247125669L;

    private String file;

    private Long templateId;
}
