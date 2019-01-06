package quick.pager.shop.goods.service;

import com.github.pagehelper.PageHelper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.goods.dto.GoodsDTO;
import quick.pager.shop.goods.mapper.GoodsMapper;
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
    public Response<List<Goods>> doService(DTO dto) {

        GoodsDTO goodsDTO = (GoodsDTO) dto;
        PageHelper.startPage(goodsDTO.getPage(),goodsDTO.getPageSize());
        List<Goods> goods = goodsMapper.selectShelfGoods();

        return new Response<>(goods);
    }
}
