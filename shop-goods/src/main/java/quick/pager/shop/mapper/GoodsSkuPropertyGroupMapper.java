package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.goods.GoodsSkuPropertyGroup;

/**
 * <p>
 * 商品sku与商品属性组property_group 关联表
 * 多对多关系 Mapper 接口
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Mapper
public interface GoodsSkuPropertyGroupMapper extends BaseMapper<GoodsSkuPropertyGroup> {

}
