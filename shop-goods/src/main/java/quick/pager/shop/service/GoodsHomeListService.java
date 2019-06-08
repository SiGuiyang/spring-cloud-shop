package quick.pager.shop.service;

import com.github.pagehelper.PageHelper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.GoodsDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.model.goods.Goods;

/**
 * 首页商品列表
 */
@Service
@Slf4j
public class GoodsHomeListService implements IService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Response<List<Goods>> doService(BaseDTO dto) {

        GoodsDTO goodsDTO = (GoodsDTO) dto;
        PageHelper.startPage(goodsDTO.getPage(), goodsDTO.getPageSize());
        List<Goods> goods = goodsMapper.selectShelfGoods();

        return new Response<>(goods);
    }
}
