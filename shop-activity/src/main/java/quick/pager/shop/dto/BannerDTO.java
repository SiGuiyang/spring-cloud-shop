package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BannerDTO extends BaseDTO {
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
