package quick.pager.shop.model.feign.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDTO extends DTO {
    private static final long serialVersionUID = 4066990868093397317L;

    private String phone;

    private String orderCode;

    private String orderStatus;

    private Integer orderType;

    private String beginTime;

    private String endTime;
}
