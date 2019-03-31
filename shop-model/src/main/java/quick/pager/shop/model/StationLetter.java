package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StationLetter extends Model {

    private static final long serialVersionUID = 1354022482374239056L;

    private Long userId;

    private String phone;

    private String content;

    private Integer status;
}