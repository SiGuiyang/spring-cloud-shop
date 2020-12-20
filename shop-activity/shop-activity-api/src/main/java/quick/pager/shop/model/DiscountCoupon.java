package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_discount_coupon")
public class DiscountCoupon extends Model {

    private static final long serialVersionUID = -5526569535126804716L;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 优惠券主键
     */
    private Long templateId;
    /**
     * 开始时间
     */
    private LocalDate beginTime;
    /**
     * 结束时间
     */
    private LocalDate endTime;
    /**
     * 使用者手机号码
     */
    private String phone;
    /**
     * 是否被使用
     */
    private Boolean used;

}
