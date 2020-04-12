package quick.pager.shop.manage.service.system;

import java.util.List;
import quick.pager.shop.manage.model.Menu;
import quick.pager.shop.manage.param.system.MenuOtherParam;
import quick.pager.shop.manage.param.system.MenuSaveParam;
import quick.pager.shop.manage.response.system.MenuResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;

/**
 * 菜单服务
 *
 * @author siguiyang
 */
public interface MenuService extends IService<Menu> {

    /**
     * 查询列表无分页
     */
    Response<List<MenuResponse>> queryList(MenuOtherParam param);

    /**
     * 新增
     */
    Response<Long> create(MenuSaveParam param);

    /**
     * 修改
     */
    Response<Long> modify(MenuSaveParam param);

    /**
     * 删除
     *
     * @param id 主键
     */
    Response<Long> delete(Long id);
}
