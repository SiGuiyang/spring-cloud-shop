package quick.pager.shop.service.system;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.MenuDTO;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.model.Menu;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.utils.DateUtils;

/**
 * 权限菜单列表
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class MenuService implements IService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Response doService(BaseDTO dto) {

        MenuDTO menuDTO = (MenuDTO) dto;
        Response response;
        switch (dto.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifyMenu(menuDTO);
                break;
            case Constants.Event.LIST:
                response = select();
                break;
            case Constants.Event.DELETE:
                response = delMenu(menuDTO.getId());
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }


        return response;
    }

    private Response select() {
        List<Menu> topMenu = menuMapper.selectTopMenu();

        List<Menu> result = Lists.newArrayList();

        Response<List<Menu>> response = new Response<>();

        response.setData(recursivePermission(result, topMenu, 1));
        return response;
    }

    /**
     * 递归迭代权限菜单列表
     *
     * @param result      菜单集合结果
     * @param permissions 权限菜单
     */
    private List<Menu> recursivePermission(List<Menu> result, List<Menu> permissions, Integer menuType) {

        permissions.forEach(k -> {
            k.setText(k.getName());
            List<Menu> list = recursivePermission(Lists.newArrayList(), menuMapper.selectSubMenu(k.getId(), menuType), menuType);
            list.forEach(l -> l.setText(l.getName()));
            if (!CollectionUtils.isEmpty(list)) {
                k.setChildren(list);
            }
            result.add(k);
        });
        return result;
    }


    private Response modifyMenu(MenuDTO dto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(dto, menu);
        if (Constants.Event.ADD.equals(dto.getEvent())) { // 新增
            menu.setMenuType(1);
            menu.setCreateTime(DateUtils.dateTime());
            menu.setDeleteStatus(Boolean.FALSE);
            menuMapper.insert(menu);
        } else {
            menuMapper.updateById(menu);
        }
        return new Response();
    }

    private Response delMenu(Long id) {

        Menu menu = menuMapper.selectById(id);

        if (ObjectUtils.isEmpty(menu)) {
            return new Response(ResponseStatus.Code.FAIL_CODE, "未知菜单");
        }

        // 顶级菜单，删除关联的子集菜单
        if (null == menu.getParentId() || 0 == menu.getParentId()) {
            List<Menu> menus = menuMapper.selectSubMenu(menu.getId(), 1);
            menus.forEach(m -> menuMapper.deleteById(m.getId()));
        }
        menuMapper.deleteById(id);
        return new Response();
    }
}
