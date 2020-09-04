package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.GoodsSkuStock;

/**
 * <p>
 * 商品库存表
 * 库存单独抽取出来
 * 用于后期扩展使用 Mapper 接口
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Mapper
public interface GoodsSkuStockMapper extends BaseMapper<GoodsSkuStock> {

}
