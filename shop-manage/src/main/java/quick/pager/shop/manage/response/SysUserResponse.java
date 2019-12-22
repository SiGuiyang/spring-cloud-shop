package quick.pager.shop.manage.response;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import lombok.Data;
import quick.pager.shop.manage.response.system.MenuResponse;

@Data
public class SysUserResponse implements Serializable {
    private static final long serialVersionUID = -8644887463379126570L;

    private String username;

    private String phone;

    private String avatar;

    private List<MenuResponse> routers = Lists.newArrayList();

    private Set<String> permissions = Sets.newHashSet();

}
