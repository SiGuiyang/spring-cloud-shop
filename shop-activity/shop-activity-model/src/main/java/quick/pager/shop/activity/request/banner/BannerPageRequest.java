package quick.pager.shop.activity.request.banner;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * Banner PageRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerPageRequest extends PageRequest {
    private static final long serialVersionUID = 6840860674650726815L;

    /**
     * 活动标题
     */
    private String title;
    /**
     * banner 类型
     */
    private String bannerType;

    /**
     * 分享渠道
     */
    private List<String> shareChannel;

}
