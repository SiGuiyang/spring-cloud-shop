package quick.pager.shop.service;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.RedisKeys;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.ClassificationDTO;
import quick.pager.shop.mapper.GoodsClassMapper;
import quick.pager.shop.goods.GoodsClass;

@Service
@Slf4j
public class GoodsModifyService implements IService {

    @Autowired
    private GoodsClassMapper goodsClassMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public Response doService(BaseDTO dto) {

        ClassificationDTO classificationDTO = (ClassificationDTO) dto;

        GoodsClass goodsClass = new GoodsClass();
        BeanUtils.copyProperties(classificationDTO, goodsClass);

        goodsClassMapper.updateByPrimaryKeySelective(goodsClass);

        Set<String> keys = redisService.keys(RedisKeys.GoodsKeys.SHOP_GOODS_CLASS);

        redisService.batchDel(keys);

        return new Response();
    }
}
