package quick.pager.shop.goods.response.classification;

import java.io.Serializable;
import lombok.Data;

/**
 * App 商品banner
 *
 * @author siguiyang
 */
@Data
public class AppGoodsBannerResponse implements Serializable {
    private static final long serialVersionUID = -3597093777641918706L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * banner图片地址
     */
    private String bannerUrl;
}
