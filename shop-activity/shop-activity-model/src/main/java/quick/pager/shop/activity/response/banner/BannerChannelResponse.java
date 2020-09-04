package quick.pager.shop.activity.response.banner;

import java.io.Serializable;
import lombok.Data;

/**
 * banner渠道
 *
 * @author siguiyang
 */
@Data
public class BannerChannelResponse implements Serializable {
    private static final long serialVersionUID = 1489702414131088409L;

    /**
     * 渠道类型
     */
    private String channelType;
    /**
     * 渠道名称
     */
    private String channelName;
}
