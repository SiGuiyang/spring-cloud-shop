package quick.pager.shop.service.system;

import java.util.List;
import quick.pager.shop.model.Menu;
import quick.pager.shop.param.system.MenuOtherParam;
import quick.pager.shop.param.system.MenuSaveParam;
import quick.pager.shop.response.system.MenuResponse;
import quick.pager.shop.user.response.Response;
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
    Response<List<MenuResponse>> queryList(final MenuOtherParam param);

    /**
     * 新增
     */
    Response<Long> create(final MenuSaveParam param);

    /**
     * 修改
     */
    Response<Long> modify(final MenuSaveParam param);

    /**
     * 删除
     *
     * @param id 主键
     */
    Response<Long> delete(final Long id);
}
