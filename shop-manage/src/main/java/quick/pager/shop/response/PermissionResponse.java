package quick.pager.shop.response;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import lombok.Data;
import quick.pager.shop.model.Menu;

@Data
public class PermissionResponse implements Serializable {


    private static final long serialVersionUID = 6106613383509895940L;

    private Set<Long> hadPermissions = Sets.newHashSet();

    private List<Menu> menus = Lists.newArrayList();
}
