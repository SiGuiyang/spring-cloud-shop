package quick.pager.shop.service;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.constants.GoodsConstants;
import quick.pager.shop.dto.GoodsSearchDTO;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.model.Goods;

/**
 * 商品搜索服务
 *
 * @author siguiyang
 */
@Service
public class GoodsSearchService implements IService<List<Goods>> {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Response<List<Goods>> doService(BaseDTO dto) {
        GoodsSearchDTO goodsSearchDTO = (GoodsSearchDTO) dto;
        List<Goods> goods = Lists.newArrayList();

        Response<List<Goods>> response = new Response<>();
        // 商品分类搜索
        if (GoodsConstants.SEARCH_CLASSIFICATION_EVENT.equals(goodsSearchDTO.getEvent())) {
            Long goodsClassId = goodsSearchDTO.getGoodsClassId();

            response = queryByClassificationId(dto.getPage(), dto.getPageSize(), goodsClassId);
        } else {
            goods = goodsMapper.selectByGoodsName(goodsSearchDTO.getGoodsName());
        }

        return response;
    }

    /**
     * 根据商品分类的Id查询商品
     *
     * @param page         页码
     * @param pageSize     页数
     * @param goodsClassId 商品分类Id
     */
    private Response<List<Goods>> queryByClassificationId(Integer page, Integer pageSize, Long goodsClassId) {


        return null;
    }
}
