package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsBrandMapper;
import quick.pager.shop.model.goods.GoodsBrand;
import quick.pager.shop.service.GoodsBrandService;

/**
 * 商品品牌
 *
 * @author siguiyang
 */
@Service
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandMapper, GoodsBrand> implements GoodsBrandService {
}
