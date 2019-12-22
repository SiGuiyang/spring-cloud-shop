package quick.pager.shop.manage.param.banner;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * banner pageParam
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerPageParam extends PageParam {
    private static final long serialVersionUID = -5568762110031538801L;

    /**
     * banner 类型
     */
    private String bannerType;
    /**
     * 活动标题
     */
    private String title;
}
