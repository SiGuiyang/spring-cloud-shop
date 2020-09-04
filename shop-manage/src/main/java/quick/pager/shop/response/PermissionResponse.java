package quick.pager.shop.response;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import quick.pager.shop.response.system.MenuResponse;

@Data
public class PermissionResponse implements Serializable {


    private static final long serialVersionUID = 6106613383509895940L;
    /**
     * 路由拥有的权限
     */
    private List<Long> routerPermission = Lists.newArrayList();
    /**
     * 按钮拥有的权限
     */
    private List<Long> btnPermission = Lists.newArrayList();
    /**
     * 路由
     */
    private List<MenuResponse> routers = Lists.newArrayList();
}
