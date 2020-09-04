package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 品牌组
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_brand_group")
public class GoodsBrandGroup extends Model {

    private static final long serialVersionUID = 1L;
    /**
     * 品牌组名称
     */
    private String brandGroupName;
    /**
     * 序号
     */
    private Integer sequence;


}
