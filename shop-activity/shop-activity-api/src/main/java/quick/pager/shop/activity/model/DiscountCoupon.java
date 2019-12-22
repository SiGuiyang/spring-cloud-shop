package quick.pager.shop.activity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_discount_coupon")
public class DiscountCoupon extends Model {

    private static final long serialVersionUID = -5526569535126804716L;

    private Long userId;

    private Long templateId;

    private String phone;

    private Boolean used;

}
