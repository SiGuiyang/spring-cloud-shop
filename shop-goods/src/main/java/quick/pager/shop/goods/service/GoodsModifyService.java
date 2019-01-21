package quick.pager.shop.goods.service;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.common.service.RedisService;
import quick.pager.shop.goods.dto.ClassificationDTO;
import quick.pager.shop.goods.mapper.GoodsClassMapper;
import quick.pager.shop.model.goods.GoodsClass;

@Service
@Slf4j
public class GoodsModifyService implements IService {

    @Autowired
    private GoodsClassMapper goodsClassMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public Response doService(DTO dto) {

        ClassificationDTO classificationDTO = (ClassificationDTO) dto;

        GoodsClass goodsClass = new GoodsClass();
        BeanUtils.copyProperties(classificationDTO, goodsClass);

        goodsClassMapper.updateByPrimaryKeySelective(goodsClass);

        Set<String> keys = redisService.keys(RedisKeys.GoodsKeys.SHOP_GOODS_CLASS);

        redisService.batchDel(keys);

        return new Response();
    }
}
