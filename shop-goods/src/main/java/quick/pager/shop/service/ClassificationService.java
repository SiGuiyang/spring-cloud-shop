package quick.pager.shop.service;

import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.RedisKeys;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.ClassificationDTO;
import quick.pager.shop.mapper.GoodsClassMapper;
import quick.pager.shop.model.goods.GoodsClass;

/**
 * 商品分类列表服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class ClassificationService implements IService {
    @Autowired
    private GoodsClassMapper goodsClassMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public Response doService(BaseDTO dto) {

        ClassificationDTO classificationDTO = (ClassificationDTO) dto;
        // 列表
        if (Constants.Event.LIST.equals(dto.getEvent())) {
            String key = RedisKeys.GoodsKeys.SHOP_GOODS_CLASS + classificationDTO.getClassName();

            Response<List<GoodsClass>> response = redisService.get(key);

            // 从缓存中取数据
            if (!ObjectUtils.isEmpty(response)) {

                return response;

            }

            response = new Response<>();

            List<GoodsClass> goodsClasses = goodsClassMapper.selectClassification(classificationDTO.getClassName());
            response.setData(goodsClasses);

            redisService.set(key, response, 30 * 24 * 60 * 60L);

            return response;

        } else if (Constants.Event.MODIFY.equals(dto.getEvent())) { // 修改

            GoodsClass goodsClass = new GoodsClass();
            BeanUtils.copyProperties(classificationDTO, goodsClass);

            goodsClassMapper.updateByPrimaryKeySelective(goodsClass);

            Set<String> keys = redisService.keys(RedisKeys.GoodsKeys.SHOP_GOODS_CLASS);

            redisService.batchDel(keys);
        }

        return new Response();
    }
}
