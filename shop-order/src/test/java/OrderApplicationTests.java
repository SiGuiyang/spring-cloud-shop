import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import quick.pager.shop.OrderApplication;
import quick.pager.shop.mapper.UserOrderMapper;
import quick.pager.shop.model.UserOrder;
import quick.pager.shop.utils.DateUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class OrderApplicationTests {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Test
    public void testOrder() {
        userOrderMapper.selectByPrimaryKey(1L);
    }
}
