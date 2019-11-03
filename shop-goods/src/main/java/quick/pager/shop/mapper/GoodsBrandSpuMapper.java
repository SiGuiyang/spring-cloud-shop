package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.goods.GoodsBrandSpu;

/**
 * <p>
 * 品牌与商品spu关联关系表
 * 多对多关系 Mapper 接口
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Mapper
public interface GoodsBrandSpuMapper extends BaseMapper<GoodsBrandSpu> {

}
