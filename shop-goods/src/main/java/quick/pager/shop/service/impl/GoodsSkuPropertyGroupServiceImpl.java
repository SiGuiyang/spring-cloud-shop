package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsSkuPropertyGroupMapper;
import quick.pager.shop.model.goods.GoodsSkuPropertyGroup;
import quick.pager.shop.service.GoodsSkuPropertyGroupService;

/**
 * <p>
 * 商品sku与商品属性组property_group 关联表
多对多关系 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsSkuPropertyGroupServiceImpl extends ServiceImpl<GoodsSkuPropertyGroupMapper, GoodsSkuPropertyGroup> implements GoodsSkuPropertyGroupService {

}
