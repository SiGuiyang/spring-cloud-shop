package quick.pager.shop.activity.response.banner;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * banner 数据响应对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerResponse extends BasicResponse {

    private static final long serialVersionUID = -3480418431962708390L;

    private Long id;
    /**
     * 活动标题
     */
    private String title;
    /**
     * banner在首页展示的图片地址
     */
    private String bannerUrl;
    /**
     * banner在首页点击的地址
     */
    private String bannerClickUrl;
    /**
     * banner 类型
     */
    private String bannerType;
    /**
     * banner类型名称
     */
    private String bannerTypeName;
    /**
     * 分享地址
     */
    private String shareUrl;
    /**
     * 分享标题
     */
    private String shareTitle;
    /**
     * 分享副标题
     */
    private String shareSubtitle;
    /**
     * 分享图标
     */
    private String shareIcon;
    /**
     * 分享渠道
     */
    private List<String> shareChannel;
    /**
     * 分享渠道名称
     */
    private String shareChannelName;

    /**
     * banner 状态
     */
    private Boolean bannerStatus;
}
