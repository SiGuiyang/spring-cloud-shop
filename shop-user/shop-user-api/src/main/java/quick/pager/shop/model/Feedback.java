package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 意见反馈
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Feedback extends Model {
    private static final long serialVersionUID = 2997049206403488676L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 反馈内容
     */
    private String content;
    /**
     * 反馈图片
     */
    private String images;

}
