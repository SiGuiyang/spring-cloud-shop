package quick.pager.shop.manage.service.system;

import java.util.List;
import quick.pager.shop.manage.param.system.MenuParam;
import quick.pager.shop.manage.response.system.MenuResponse;
import quick.pager.shop.response.Response;

/**
 * 菜单服务
 *
 * @author siguiyang
 */
public interface MenuService {

    /**
     * 查询列表无分页
     */
    Response<List<MenuResponse>> queryList();

    /**
     * 新增
     */
    Response<Long> create(MenuParam param);

    /**
     * 修改
     */
    Response<Long> modify(MenuParam param);

    /**
     * 删除
     *
     * @param id 主键
     */
    Response<Long> delete(Long id);
}
