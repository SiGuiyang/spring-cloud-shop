package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 首页banner
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_banner")
public class Banner extends Model {

    private static final long serialVersionUID = 2497737003636382468L;

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
    private String shareSubtitle;
    /**
     * 分享图标
     */
    private String shareIcon;
    /**
     * 分享渠道
     */
    private String shareChannel;
    /**
     * banner 状态
     * false 开启， true 禁用
     */
    private Boolean bannerStatus;

}
