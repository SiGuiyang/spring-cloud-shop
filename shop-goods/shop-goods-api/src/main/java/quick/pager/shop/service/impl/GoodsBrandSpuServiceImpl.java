package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsBrandSpuMapper;
import quick.pager.shop.model.GoodsBrandSpu;
import quick.pager.shop.service.GoodsBrandSpuService;

/**
 * <p>
 * 品牌与商品spu关联关系表
多对多关系 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsBrandSpuServiceImpl extends ServiceImpl<GoodsBrandSpuMapper, GoodsBrandSpu> implements GoodsBrandSpuService {

}
