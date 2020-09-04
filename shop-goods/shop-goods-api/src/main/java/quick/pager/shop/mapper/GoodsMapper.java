package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.Goods;

/**
 * 商品主表
 *
 * @author siguiyang
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
