package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class IntegralLog extends Model {
    private static final long serialVersionUID = -8874907953710748883L;

    private Long userId;

    private Long integral;

    private String description;

}