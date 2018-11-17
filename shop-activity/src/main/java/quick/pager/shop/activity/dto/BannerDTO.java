package quick.pager.shop.activity.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class BannerDTO extends DTO {
    private static final long serialVersionUID = 2378276818835084161L;


    private String device;

}
