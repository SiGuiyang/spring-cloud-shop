package quick.pager.shop.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 图片对象
 *
 * @author siguiyang
 */
@Data
public class ImageModel implements Serializable {
    private static final long serialVersionUID = -5855220795903948607L;

    /**
     * 图片绝对地址
     */
    private String url;
    /**
     * 图片名称
     */
    private String name;
    /**
     * 主图是true，反之亦然
     */
    private Boolean master;
}
