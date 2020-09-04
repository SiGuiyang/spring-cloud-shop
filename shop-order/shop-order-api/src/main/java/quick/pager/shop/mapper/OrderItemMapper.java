package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.OrderItem;

/**
 * 订单商品明细
 * @author siguiyang
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
