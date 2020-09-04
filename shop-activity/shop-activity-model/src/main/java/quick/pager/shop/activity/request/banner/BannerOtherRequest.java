package quick.pager.shop.activity.request.banner;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * Banner PageRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerOtherRequest extends Request {

    private static final long serialVersionUID = 9167439469144610401L;
    /**
     * 活动标题
     */
    private String title;
    /**
     * banner 类型
     */
    private String bannerType;
    /**
     * banner 状态
     */
    private Boolean bannerStatus;
    /**
     * 分享渠道
     */
    private List<String> shareChannel;

}
