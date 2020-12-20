import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import quick.pager.shop.Manage;
import quick.pager.shop.mapper.MenuMapper;
import quick.pager.shop.model.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Manage.class)
public class ManageTests {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testMenu() {
        List<Menu> menus = menuMapper.selectList(new QueryWrapper<>());


        System.out.println("==================");

        System.out.println(JSON.toJSONString(menus.stream().map(item -> ImmutableMap.of(item.getPermission(), item.getPermission(), "// ", item.getName())).collect(Collectors.toList())));
    }


    @Test
    public void test() {
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(1 ==1 , Menu::getName, "系统管理");
        List<Menu> menus = menuMapper.selectList(wrapper);

        System.out.println(menus);
    }
}
