import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import quick.pager.shop.manage.ManageApplication;
import quick.pager.shop.manage.mapper.MenuMapper;
import quick.pager.shop.manage.model.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ManageApplication.class)
public class ManageApplicationTests {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testMenu() {
        List<Menu> menus = menuMapper.selectList(new QueryWrapper<>());


        System.out.println("==================");

        System.out.println(JSON.toJSONString(menus.stream().map(item -> ImmutableMap.of(item.getPermission(), item.getPermission(), "// ", item.getName())).collect(Collectors.toList())));
    }
}
