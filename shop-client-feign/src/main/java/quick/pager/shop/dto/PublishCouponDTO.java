package quick.pager.shop.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class PublishCouponDTO extends ManageDTO {
    private static final long serialVersionUID = 1890447832247125669L;

    @NotBlank(message = "上传文件不能为空")
    private String file;
    @NotBlank(message = "请选择优惠券模板")
    private Long templateId;
}
