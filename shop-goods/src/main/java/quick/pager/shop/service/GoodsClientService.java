package quick.pager.shop.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.GoodsDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.mapper.GoodsCartMapper;
import quick.pager.shop.mapper.GoodsDetailMapper;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.service.common.CommonGoodsService;
import quick.pager.shop.model.Goods;
import quick.pager.shop.model.GoodsCart;
import quick.pager.shop.model.GoodsDetail;

@Service
@Slf4j
public class GoodsClientService {

    @Autowired
    private GoodsCartMapper goodsCartMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsDetailMapper goodsDetailMapper;
    @Autowired
    private CommonGoodsService commonGoodsService;


    /**
     * 查询商品列表 管理后台
     */
    public Response<List<Goods>> queryGoodsList(GoodsDTO request) {
        PageHelper.startPage(request.getPage(), request.getPageSize());
        List<Goods> goods = goodsMapper.queryGoodsList(request.getGoodsName(), request.getGoodsStatus(),
                request.getGoodsType(), request.getGcsId());
        return Response.toResponse(goods);
    }

    /**
     * 新增|修改
     */
    public Response<String> modifyGoods(GoodsDTO request) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(request, goods);

        GoodsDetail goodsDetail = new GoodsDetail();
        BeanUtils.copyProperties(request, goodsDetail);

        // 新增
        if (Constants.Event.ADD.equals(request.getEvent())) {
            // 保存商品
            goods.setGoodsCode(DateUtil.current(false) + RandomUtil.randomString(5));
            goods.setCreateTime(new Date());
            goods.setDeleteStatus(false);
            goodsMapper.insertSelective(goods);

            // 保存商品详情
            goodsDetail.setGoodsId(goods.getId());
            goodsDetail.setCreateTime(new Date());
            goodsDetail.setDeleteStatus(false);
            goodsDetailMapper.insertSelective(goodsDetail);

        } else { // 修改
            goodsMapper.updateByPrimaryKeySelective(goods);
            goodsDetail.setId(request.getGoodsDetailId());
            goodsDetailMapper.updateByPrimaryKeySelective(goodsDetail);
        }

        return new Response<>();
    }


    /**
     * 根据订单中的购物车Id 获取购买的商品
     *
     * @param buyerOrderCartId 订单中购物车的id
     */
    public Response<List<GoodsResponse>> queryBuyerOrderGoods(Long buyerOrderCartId) {

        List<GoodsCart> goodsCarts = goodsCartMapper.selectByBuyCartId(buyerOrderCartId);

        List<GoodsResponse> goodsResponses = commonGoodsService.transGoods(goodsCarts);

        return new Response<>(goodsResponses);
    }

}
