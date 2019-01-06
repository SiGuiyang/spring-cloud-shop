package quick.pager.shop.goods.service;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.goods.constants.GoodsConstants;
import quick.pager.shop.goods.dto.GoodsSearchDTO;
import quick.pager.shop.goods.mapper.GoodsMapper;
import quick.pager.shop.model.goods.Goods;

/**
 * 商品搜索服务
 * @author siguiyang
 */
@Service
public class GoodsSearchService implements IService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Response doService(DTO dto) {
        GoodsSearchDTO goodsSearchDTO = (GoodsSearchDTO) dto;
        List<Goods> goods = Lists.newArrayList();
        // 商品分类搜索
        if (GoodsConstants.SEARCH_CLASSIFICATION_EVENT.equals(goodsSearchDTO.getEvent())) {
            Long goodsClassId = goodsSearchDTO.getGoodsClassId();
            goods = goodsMapper.selectByGoodsClassId(goodsClassId);
        }
        else
        {
            goods = goodsMapper.selectByGoodsName(goodsSearchDTO.getGoodsName());
        }

        return null;
    }
}
