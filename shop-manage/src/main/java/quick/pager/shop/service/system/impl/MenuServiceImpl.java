package quick.pager.shop.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.param.system.MenuOtherParam;
import quick.pager.shop.param.system.MenuSaveParam;
import quick.pager.shop.response.system.MenuResponse;
import quick.pager.shop.service.system.MenuService;
import quick.pager.shop.model.Menu;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * MenuServiceImpl
 *
 * @author siguiyang
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public Response<Long> create(final MenuSaveParam param) {
        Menu menu = new Menu();
        BeanCopier.create(param, menu).copy();
        menu.setMenuType(1);
        menu.setCreateTime(DateUtils.dateTime());
        menu.setUpdateTime(DateUtils.dateTime());
        menu.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(menu);
        return Response.toResponse(menu.getId());
    }

    @Override
    public Response<Long> modify(final MenuSaveParam param) {
        Menu menu = new Menu();
        BeanCopier.copy(param, menu);
        menu.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(menu);
        return Response.toResponse(menu.getId());
    }

    @Override
    public Response<List<MenuResponse>> queryList(final MenuOtherParam param) {

        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Menu::getDeleteStatus, Boolean.FALSE);
        if (StringUtils.isNotBlank(param.getName())) {
            wrapper.likeRight(Menu::getName, param.getName());
        }
        if (Objects.nonNull(param.getMenuType())) {
            wrapper.eq(Menu::getMenuType, param.getMenuType());
        }
        wrapper.orderByAsc(Menu::getSequence);
        List<Menu> menus = this.baseMapper.selectList(wrapper);
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

        return Response.toResponse(parentResp, 0L);
    }

    @Override
    public Response<Long> delete(final Long id) {
        this.baseMapper.deleteById(id);
        return Response.toResponse(id);
    }

    /**
     * 树形结构转换
     *
     * @param parentResp  顶级菜单
     * @param childrenMap 孩子节点
     */
    private void toTree(final List<MenuResponse> parentResp, final Map<Long, List<MenuResponse>> childrenMap) {
        parentResp.forEach(item -> {
            List<MenuResponse> list = childrenMap.get(item.getId());
            toTree(Optional.ofNullable(list).orElse(Collections.emptyList()), childrenMap);
            item.setChildren(list);
        });
    }

    private MenuResponse conv(final Menu menu) {
        MenuResponse resp = new MenuResponse();
        BeanCopier.create(menu, resp).copy();
        resp.setLabel(menu.getName());
        return resp;
    }
}
