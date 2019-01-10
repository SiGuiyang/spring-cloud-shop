package quick.pager.shop.model.feign.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class CouponResponse implements Serializable {
    private static final long serialVersionUID = -6781079386405136237L;
    /**
     * 数据库主键
     */
    private Long id;

    private Long userId;

    private Long templateId;

    private String phone;

    private String username;

    private String couponName;

    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer discountType;

    private Date beginTime;

    private Date endTime;

    private String description;

    /**
     * 数据库记录创建时间
     */
    private Date createTime;
    /**
     * 数据库删除标志<br />
     * 1: 删除
     * 0: 未删除
     */
    private Boolean deleteStatus;
}
