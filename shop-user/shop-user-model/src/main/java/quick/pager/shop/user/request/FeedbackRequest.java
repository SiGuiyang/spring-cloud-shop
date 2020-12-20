package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 意见反馈
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FeedbackRequest extends Request {
    private static final long serialVersionUID = 9166714534870089988L;

    /**
     * 反馈内容
     */
    private String content;
    /**
     * 反馈图片
     */
    private String images;
}
