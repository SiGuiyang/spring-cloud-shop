package quick.pager.shop.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class StationLetter extends Model {

    private static final long serialVersionUID = 1354022482374239056L;

    private Long userId;

    private String phone;

    private String content;

    private Integer status;
}