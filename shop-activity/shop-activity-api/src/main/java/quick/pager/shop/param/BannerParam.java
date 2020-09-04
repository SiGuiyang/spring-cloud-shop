package quick.pager.shop.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * banner 请求参数
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerParam extends Param {
    private static final long serialVersionUID = 2378276818835084161L;

    /**
     * 活动标题
     */
    private String title;

    private String bannerType;

    /**
     * 分享渠道
     */
    private String shareChannel;

}
