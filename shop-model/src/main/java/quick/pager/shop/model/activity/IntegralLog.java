package quick.pager.shop.model.activity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class IntegralLog extends Model {
    private static final long serialVersionUID = -8874907953710748883L;

    private Long userId;

    private Long integral;

    private String description;

}
