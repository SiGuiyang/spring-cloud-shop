package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsSkuPropertyMapper;
import quick.pager.shop.model.GoodsSkuProperty;
import quick.pager.shop.service.GoodsSkuPropertyService;

/**
 * <p>
 * 商品sku 与商品属性组关联关系表
多对多关系 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsSkuPropertyServiceImpl extends ServiceImpl<GoodsSkuPropertyMapper, GoodsSkuProperty> implements GoodsSkuPropertyService {

}
