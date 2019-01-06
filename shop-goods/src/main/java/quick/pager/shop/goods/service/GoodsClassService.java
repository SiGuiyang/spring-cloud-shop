package quick.pager.shop.goods.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.goods.mapper.GoodsClassMapper;
import quick.pager.shop.goods.redis.RedisService;
import quick.pager.shop.model.goods.GoodsClass;

/**
 * 商品分类列表服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class GoodsClassService implements IService<List<GoodsClass>> {
    @Autowired
    private GoodsClassMapper goodsClassMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public Response<List<GoodsClass>> doService(DTO dto) {

        String key = RedisKeys.GoodsKeys.SHOP_GOODS_CLASS;

        Response<List<GoodsClass>> response = redisService.get(key);

        // 从缓存中取数据
        if (!ObjectUtils.isEmpty(response)) {

            return response;

        }

        response = new Response<>();

        List<GoodsClass> goodsClasses = goodsClassMapper.selectAll();
        response.setData(goodsClasses);

        redisService.set(key, response, 30 * 24 * 60 * 60L);

        return response;
    }
}
