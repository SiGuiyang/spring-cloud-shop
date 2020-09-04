package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsSkuStockMapper;
import quick.pager.shop.model.GoodsSkuStock;
import quick.pager.shop.service.GoodsSkuStockService;

/**
 * <p>
 * 商品库存表
库存单独抽取出来
用于后期扩展使用 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsSkuStockServiceImpl extends ServiceImpl<GoodsSkuStockMapper, GoodsSkuStock> implements GoodsSkuStockService {

}
