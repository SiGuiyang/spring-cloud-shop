package quick.pager.shop.manage.param.banner;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * banner saveParam
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerSaveParam extends Param {
    private static final long serialVersionUID = -7250247329909085720L;

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
    private String ShareSubtitle;
    /**
     * 分享图标
     */
    private String shareIcon;
    /**
     * 分享渠道
     */
    private List<String> shareChannel;

    /**
     * banner 状态
     */
    private Boolean bannerStatus;
}
