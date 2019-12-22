package quick.pager.shop.manage.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import quick.pager.shop.manage.mapper.MenuMapper;
import quick.pager.shop.manage.param.system.MenuParam;
import quick.pager.shop.manage.response.system.MenuResponse;
import quick.pager.shop.manage.service.system.MenuService;
import quick.pager.shop.manage.model.Menu;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public Response<Long> create(MenuParam param) {
        Menu menu = new Menu();
        BeanCopier.create(param, menu).copy();
        menu.setMenuType(1);
        menu.setCreateTime(DateUtils.dateTime());
        menu.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(menu);
        return new Response<>(menu.getId());
    }

    @Override
    public Response<Long> modify(MenuParam param) {
        Menu menu = new Menu();
        BeanCopier.create(param, menu).copy();
        this.baseMapper.updateById(menu);
        return new Response<>(menu.getId());
    }

    @Override
    public Response<List<MenuResponse>> queryList() {

        Menu menu = new Menu();
        menu.setDeleteStatus(Boolean.FALSE);
        List<Menu> menus = this.baseMapper.selectList(new QueryWrapper<>(menu));

        List<MenuResponse> parentResp = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
                .filter(item -> Objects.isNull(item.getParentId()))
                .map(this::conv)
                .collect(Collectors.toList());
        Map<Long, List<MenuResponse>> childrenMap = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
                .filter(item -> Objects.nonNull(item.getParentId()))
                .map(this::conv)
                .collect(Collectors.groupingBy(MenuResponse::getParentId, Collectors.toList()));

        // 数据转换
        toTree(parentResp, childrenMap);

        return new Response<>(parentResp);
    }

    @Override
    public Response<Long> delete(Long id) {
        Menu menu = new Menu();
        menu.setDeleteStatus(Boolean.TRUE);
        this.baseMapper.updateById(menu);
        return new Response<>(id);
    }

    /**
     * 树形结构转换
     *
     * @param parentResp  顶级菜单
     * @param childrenMap 孩子节点
     */
    private void toTree(List<MenuResponse> parentResp, Map<Long, List<MenuResponse>> childrenMap) {
        parentResp.forEach(item -> {
            List<MenuResponse> list = childrenMap.get(item.getId());
            toTree(Optional.ofNullable(list).orElse(Collections.emptyList()), childrenMap);
            item.setChildren(list);
        });
    }

    private MenuResponse conv(Menu menu) {
        MenuResponse resp = new MenuResponse();
        BeanCopier.create(menu, resp).copy();
        resp.setLabel(menu.getName());
        return resp;
    }
}
