package quick.pager.shop.response;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class SysUserResponse implements Serializable {
    private static final long serialVersionUID = -8644887463379126570L;

    private String sysName;

    private String sysCode;

    private String avatar;

    private List<String> permission = Lists.newArrayList();
}
