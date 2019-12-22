package quick.pager.shop.manage.response;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import lombok.Data;
import quick.pager.shop.manage.response.system.MenuResponse;

@Data
public class PermissionResponse implements Serializable {


    private static final long serialVersionUID = 6106613383509895940L;

    private Set<Long> hadPermissions = Sets.newHashSet();

    private List<MenuResponse> menus = Lists.newArrayList();
}
