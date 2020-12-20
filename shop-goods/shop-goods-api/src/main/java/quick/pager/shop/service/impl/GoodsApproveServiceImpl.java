package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quick.pager.shop.goods.enums.GoodsPublishStatusEnum;
import quick.pager.shop.goods.request.GoodsApproveRequest;
import quick.pager.shop.goods.response.GoodsApproveResponse;
import quick.pager.shop.mapper.GoodsApproveMapper;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.mapper.GoodsSkuMapper;
import quick.pager.shop.model.Goods;
import quick.pager.shop.model.GoodsApprove;
import quick.pager.shop.model.GoodsSku;
import quick.pager.shop.service.GoodsApproveService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;
import quick.pager.shop.utils.DateUtils;

@Service
@Slf4j
public class GoodsApproveServiceImpl implements GoodsApproveService {

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsApproveMapper goodsApproveMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<Long> create(final GoodsApproveRequest request) {

        GoodsPublishStatusEnum publishStatusEnum = Enum.valueOf(GoodsPublishStatusEnum.class, request.getPublishStatus());

        // 创建审核记录
        GoodsApprove approve = new GoodsApprove();
        approve.setGoodsId(request.getGoodsId());
        approve.setSkuId(request.getSkuId());
        approve.setPublishStatus(publishStatusEnum.getCode());
        approve.setDescription(request.getDescription());
        approve.setCreateTime(DateUtils.dateTime());
        approve.setUpdateTime(DateUtils.dateTime());
        approve.setCreateUser(request.getCreateUser());
        approve.setUpdateUser(request.getUpdateUser());
        approve.setDeleteStatus(Boolean.FALSE);
        Assert.isTrue(this.goodsApproveMapper.insert(approve) > 0, () -> "审核失败");

        Goods goods = new Goods();
        goods.setPublishStatus(publishStatusEnum.getCode());
        goods.setUpdateTime(DateUtils.dateTime());
        goods.setUpdateUser(request.getUpdateUser());
        int update = this.goodsMapper.update(goods, new LambdaQueryWrapper<Goods>().eq(Goods::getId, request.getGoodsId()));

        Assert.isTrue(update > 0, () -> "更新商品主表状态失败");

        // 审核通过，自动更新sku状态为上架
        if (GoodsPublishStatusEnum.PASS.equals(publishStatusEnum)) {
            GoodsSku updateGoodsSku = new GoodsSku();
            updateGoodsSku.setId(request.getSkuId());
            updateGoodsSku.setState(Boolean.TRUE);
            updateGoodsSku.setUpdateTime(DateUtils.dateTime());
            updateGoodsSku.setUpdateUser(request.getUpdateUser());
            int skuStatus = this.goodsSkuMapper.update(updateGoodsSku, new LambdaQueryWrapper<GoodsSku>().eq(GoodsSku::getId, request.getSkuId()));

            Assert.isTrue(skuStatus > 0, () -> "更新商品状态失败");
        }

        return Response.toResponse(approve.getId());
    }

    @Override
    public Response<GoodsApproveResponse> detail(final Long skuId, final Long goodsId) {

        Goods goods = this.goodsMapper.selectById(goodsId);
        Assert.isTrue(Objects.nonNull(goods), () -> "商品主信息不存在");

        GoodsSku goodsSku = this.goodsSkuMapper.selectById(skuId);
        Assert.isTrue(Objects.nonNull(goodsSku), () -> "商品不存在");

        GoodsApprove approve = this.goodsApproveMapper.selectOne(new LambdaQueryWrapper<GoodsApprove>()
                .eq(GoodsApprove::getGoodsId, goodsId)
                .eq(GoodsApprove::getSkuId, skuId));
        // 审核信息不存在
        if (Objects.isNull(approve)) {
            return Response.toResponse();
        }


        return Response.toResponse(this.convert(approve));
    }

    /**
     * 数据转换
     *
     * @param approve 审核信息
     */
    private GoodsApproveResponse convert(final GoodsApprove approve) {
        return GoodsApproveResponse.builder()
                .goodsId(approve.getGoodsId())
                .skuId(approve.getSkuId())
                .description(approve.getDescription())
                .build();
    }
}
