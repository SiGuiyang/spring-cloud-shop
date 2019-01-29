package quick.pager.shop.feign.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class SellerOrderDTO extends ManageDTO {
    private static final long serialVersionUID = 2370158929485767003L;
}
