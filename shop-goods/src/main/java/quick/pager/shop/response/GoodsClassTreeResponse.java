package quick.pager.shop.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class GoodsClassTreeResponse implements Serializable {
    private static final long serialVersionUID = 2122631393757955343L;

    private Long value;

    private String label;

    private List<GoodsClassTreeResponse> children;
}
