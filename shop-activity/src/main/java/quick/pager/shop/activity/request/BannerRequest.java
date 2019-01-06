package quick.pager.shop.activity.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class BannerRequest extends Request {

    private static final long serialVersionUID = -4915905938338821122L;
    private String bannerType;
}
