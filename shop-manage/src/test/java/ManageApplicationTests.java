
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import quick.pager.shop.ManageApplication;
import quick.pager.shop.mapper.ColumnsMapper;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.mapper.SysUserMapper;
import quick.pager.shop.mapper.TablesMapper;
import quick.pager.shop.model.Menu;
import quick.pager.shop.model.SysUser;
import quick.pager.shop.model.Tables;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageApplication.class)
@ActiveProfiles("dev")
public class ManageApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private TablesMapper tablesMapper;
    @Autowired
    private ColumnsMapper columnsMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testSysUserRole() {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(1L);

        System.out.println(sysUser);
    }

    @Test
    public void testTables() {
        List<Tables> jcrabs = tablesMapper.selectTables("pager_order", "t_user_order");

        System.out.println(jcrabs);
    }


    @Test
    public void test2() {
        List<Menu> menus = menuMapper.selectMenuBySysUserId(1L);

        List<Menu> res = recursivePermission(Lists.newArrayList(), menus, null, null);

    }


    /**
     * 获取访问菜单
     *
     * @param result      菜单
     * @param menus       菜单
     * @param permissions 权限
     * @param menuType    菜单类型
     */
    private List<Menu> recursivePermission(List<Menu> result, List<Menu> menus, Set<String> permissions, Integer menuType) {

        menus.forEach(k -> {
            Menu.Meta meta = new Menu.Meta(k.getName(), k.getIcon(), k.getHidden(), permissions);
            k.setMeta(meta);
            // 顶级菜单的 component 元素值设置为Layout
            if (null == k.getParentId()) {
                k.setComponent("Layout");
            }
            List<Menu> list = recursivePermission(Lists.newArrayList(), menuMapper.selectSubMenu(k.getId(), menuType), permissions, menuType);
            k.setChildren(list);
            result.add(k);
        });
        return result;
    }
}
