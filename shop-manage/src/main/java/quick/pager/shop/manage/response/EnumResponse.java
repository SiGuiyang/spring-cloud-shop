package quick.pager.shop.manage.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class EnumResponse implements Serializable{

    private static final long serialVersionUID = -1280398705355998555L;

    private Integer type;

    private String key;

    private String value;
}
