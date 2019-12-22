package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import quick.pager.shop.goods.mapper.GoodsSkuStockMapper;
import quick.pager.shop.goods.model.GoodsSkuStock;
import quick.pager.shop.goods.service.GoodsSkuStockService;

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
