package quick.pager.shop.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.dto.UploadDTO;
import quick.pager.shop.goods.enums.GoodsPublishStatusEnum;
import quick.pager.shop.goods.enums.GoodsTypeEnum;
import quick.pager.shop.mapper.GoodsClassMapper;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.mapper.GoodsSkuImageMapper;
import quick.pager.shop.mapper.GoodsSkuMapper;
import quick.pager.shop.mapper.GoodsSkuStockMapper;
import quick.pager.shop.mapper.GoodsSpuMapper;
import quick.pager.shop.model.Goods;
import quick.pager.shop.model.GoodsClass;
import quick.pager.shop.goods.request.GoodsPageRequest;
import quick.pager.shop.goods.request.GoodsSaveRequest;
import quick.pager.shop.goods.response.GoodsResponse;
import quick.pager.shop.model.GoodsSku;
import quick.pager.shop.model.GoodsSkuImage;
import quick.pager.shop.model.GoodsSkuStock;
import quick.pager.shop.model.GoodsSpu;
import quick.pager.shop.service.GoodsService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.DateUtils;

/**
 * GoodsServiceImpl
 *
 * @author siguiyang
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsClassMapper goodsClassMapper;
    @Autowired
    private GoodsSkuMapper goodsSkuMapper;
    @Autowired
    private GoodsSpuMapper goodsSpuMapper;
    @Autowired
    private GoodsSkuImageMapper goodsSkuImageMapper;
    @Autowired
    private GoodsSkuStockMapper goodsSkuStockMapper;

    private static final String SKU_PREFIX = "SKU";

    @Override
    public Response<List<GoodsResponse>> queryPage(GoodsPageRequest request) {
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<>();

        // 检索sku名称
        if (StringUtils.isNotBlank(request.getKeyword())) {

            List<GoodsSku> skus = this.goodsSkuMapper.selectList(new LambdaQueryWrapper<GoodsSku>()
                    .like(GoodsSku::getSkuName, request.getKeyword())
                    .select(GoodsSku::getGoodsId));
            // 商品集
            wrapper.in(Goods::getId, skus.stream().map(GoodsSku::getGoodsId).collect(Collectors.toList()));
        }

        // 商品状态
        if (Objects.nonNull(request.getState())) {
            List<GoodsSku> skus = this.goodsSkuMapper.selectList(new LambdaQueryWrapper<GoodsSku>()
                    .eq(GoodsSku::getState, request.getState())
                    .select(GoodsSku::getGoodsId));
            if (CollectionUtils.isEmpty(skus)) {
                return Response.toResponse();
            }
            // 商品集
            wrapper.in(Goods::getId, skus.stream().map(GoodsSku::getGoodsId).collect(Collectors.toList()));
        }
        // 分类
        if (Objects.nonNull(request.getGoodsClassId())) {
            wrapper.eq(Goods::getGoodsClassId, request.getGoodsClassId());
        }

        // 审核状态
        if (Objects.nonNull(request.getPublishStatus())) {
            wrapper.eq(Goods::getPublishStatus, request.getPublishStatus());
        }
        // 推荐
        if (Objects.nonNull(request.getRecommend())) {
            wrapper.eq(Goods::getRecommend, request.getRecommend());
        }
        // 新品
        if (Objects.nonNull(request.getGoodsState())) {
            wrapper.eq(Goods::getGoodsState, request.getGoodsState());
        }

        Response<List<Goods>> page = this.toPage(request.getPage(), request.getPageSize(), wrapper);

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList())
                , page.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<Long> create(final GoodsSaveRequest request) {
        // 1. 创建商品主表
        Goods goods = this.convert(request);
        goods.setPublishStatus(GoodsPublishStatusEnum.NONE_SHELF.getCode());
        goods.setCreateTime(DateUtils.dateTime());
        goods.setUpdateTime(DateUtils.dateTime());
        goods.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(goods);
        // 2. 创建sku
        GoodsSku sku = this.convertSku(request);
        sku.setState(Boolean.FALSE);
        sku.setGoodsId(goods.getId());
        sku.setSkuCode(SKU_PREFIX + IdUtil.createSnowflake(1L, 5L).nextId());
        sku.setCreateTime(DateUtils.dateTime());
        sku.setUpdateTime(DateUtils.dateTime());
        sku.setDeleteStatus(Boolean.FALSE);
        this.goodsSkuMapper.insert(sku);
        // 3. 插入sku 图片
        GoodsSkuImage skuImage = this.convertImage(request);
        skuImage.setGoodsId(goods.getId());
        skuImage.setSkuId(sku.getId());
        skuImage.setCreateTime(DateUtils.dateTime());
        skuImage.setUpdateTime(DateUtils.dateTime());
        skuImage.setDeleteStatus(Boolean.FALSE);
        this.goodsSkuImageMapper.insert(skuImage);

        // 4. 插入入库量
        GoodsSkuStock stock = this.convertStock(request);
        stock.setGoodsId(goods.getId());
        stock.setSkuId(sku.getId());
        stock.setCreateTime(DateUtils.dateTime());
        stock.setUpdateTime(DateUtils.dateTime());
        stock.setDeleteStatus(Boolean.FALSE);
        this.goodsSkuStockMapper.insert(stock);

        return Response.toResponse(goods.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<Long> modify(final GoodsSaveRequest request) {

        // 1. 更新商品主表
        Goods goods = this.convert(request);
        goods.setId(request.getId());
        goods.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(goods);
        // 2. 更新sku
        GoodsSku sku = this.convertSku(request);
        sku.setUpdateTime(DateUtils.dateTime());

        this.goodsSkuMapper.update(sku, new LambdaQueryWrapper<GoodsSku>()
                .eq(GoodsSku::getGoodsId, goods.getId()));
        // 3. 更新sku 图片
        GoodsSkuImage skuImage = this.convertImage(request);
        skuImage.setUpdateTime(DateUtils.dateTime());
        this.goodsSkuImageMapper.update(skuImage, new LambdaQueryWrapper<GoodsSkuImage>()
                .eq(GoodsSkuImage::getGoodsId, goods.getId()));

        // 4. 更新入库量
        GoodsSkuStock stock = this.convertStock(request);
        stock.setUpdateTime(DateUtils.dateTime());
        this.goodsSkuStockMapper.update(stock, new LambdaQueryWrapper<GoodsSkuStock>()
                .eq(GoodsSkuStock::getGoodsId, goods.getId()));
        return Response.toResponse(goods.getId());
    }

    @Override
    public Response<Long> state(final Long skuId) {

        GoodsSku sku = this.goodsSkuMapper.selectById(skuId);

        if (Objects.isNull(sku)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "商品不存在");
        }

        GoodsSku updateGoodsSku = new GoodsSku();

        updateGoodsSku.setId(skuId);
        updateGoodsSku.setUpdateTime(DateUtils.dateTime());
        updateGoodsSku.setState(!sku.getState());

        this.goodsSkuMapper.updateById(updateGoodsSku);

        return Response.toResponse(skuId);
    }

    @Override
    public Response<GoodsResponse> detail(final Long id) {

        Goods goods = this.baseMapper.selectById(id);


        return Response.toResponse(this.convertDetail(goods));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<Long> delete(final Long id) {

        Goods goods = this.baseMapper.selectById(id);
        if (Objects.isNull(goods)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "商品主信息不存在");
        }

        GoodsSku sku = this.goodsSkuMapper.selectOne(new LambdaQueryWrapper<GoodsSku>().eq(GoodsSku::getGoodsId, id));

        if (Objects.isNull(sku)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "商品不存在");
        }

        this.baseMapper.deleteById(id);

        this.goodsSkuMapper.deleteById(sku.getId());

        // sku主图
        GoodsSkuImage skuImage = this.goodsSkuImageMapper.selectOne(new LambdaQueryWrapper<GoodsSkuImage>()
                .eq(GoodsSkuImage::getSkuId, sku.getId()));

        if (Objects.nonNull(skuImage)) {
            this.goodsSkuImageMapper.deleteById(skuImage.getId());
        }

        // 商品库存
        GoodsSkuStock stock = this.goodsSkuStockMapper.selectOne(new LambdaQueryWrapper<GoodsSkuStock>()
                .eq(GoodsSkuStock::getStock, sku.getId()));

        if (Objects.nonNull(stock)) {
            this.goodsSkuStockMapper.deleteById(stock.getId());
        }


        return Response.toResponse(id);
    }

    /**
     * GoodsSaveRequest -> Goods
     *
     * @param request 参数
     * @return goods
     */
    private Goods convert(final GoodsSaveRequest request) {
        Goods goods = new Goods();
        goods.setGoodsType(request.getGoodsType());
        goods.setRecommend(request.getRecommend());
        goods.setGoodsState(request.getGoodsState());

        goods.setBeginTime(request.getBeginTime());
        goods.setEndTime(request.getEndTime());
        goods.setGoodsClassId(request.getGoodsClassId());
        goods.setUnit(request.getUnit());
        goods.setUpdateUser(request.getUpdateUser());
        goods.setCreateUser(request.getCreateUser());
        return goods;
    }


    /**
     * GoodsSaveRequest -> GoodsSku
     *
     * @param request 参数
     * @return goods
     */
    private GoodsSku convertSku(final GoodsSaveRequest request) {
        GoodsSku sku = new GoodsSku();
        sku.setSkuName(request.getSkuName());
        sku.setDescription(request.getDescription());
        sku.setWeight(request.getWeight());
        sku.setSkuAmount(request.getSkuAmount());
        sku.setDiscountAmount(request.getDiscountAmount());
        sku.setUpdateUser(request.getUpdateUser());
        sku.setCreateUser(request.getCreateUser());
        return sku;
    }

    /**
     * GoodsSaveRequest -> GoodsSkuImage
     *
     * @param request 参数
     * @return goods
     */
    private GoodsSkuImage convertImage(final GoodsSaveRequest request) {
        GoodsSkuImage skuImage = new GoodsSkuImage();
        skuImage.setImages(JSON.toJSONString(request.getImages()));
        skuImage.setUpdateUser(request.getUpdateUser());
        skuImage.setCreateUser(request.getCreateUser());
        return skuImage;
    }

    /**
     * GoodsSaveRequest -> GoodsSkuStock
     *
     * @param request 参数
     * @return goods
     */
    private GoodsSkuStock convertStock(final GoodsSaveRequest request) {
        GoodsSkuStock stock = new GoodsSkuStock();
        stock.setStock(request.getStock());
        stock.setUpdateUser(request.getUpdateUser());
        stock.setCreateUser(request.getCreateUser());
        return stock;
    }

    /**
     * Goods -> GoodsResponse
     *
     * @param goods 商品主信息
     * @return 数据响应
     */
    private GoodsResponse convert(final Goods goods) {
        GoodsResponse response = new GoodsResponse();
        response.setId(goods.getId());
        response.setUnit(goods.getUnit());
        response.setGoodsState(goods.getGoodsState());
        response.setRecommend(goods.getRecommend());
        response.setUpdateTime(goods.getUpdateTime());
        response.setUpdateUser(goods.getUpdateUser());

        GoodsTypeEnum typeEnum = GoodsTypeEnum.parse(goods.getGoodsType());
        response.setGoodsType(goods.getGoodsType());
        response.setGoodsTypeName(null != typeEnum ? typeEnum.getName() : null);
        // 商品状态
        GoodsPublishStatusEnum statusEnum = GoodsPublishStatusEnum.parse(goods.getPublishStatus());
        response.setPublishStatus(goods.getPublishStatus());
        response.setPublishStatusName(null != statusEnum ? statusEnum.getDesc() : null);

        this.convert(response, goods, false);

        return response;
    }


    /**
     * Goods -> GoodsResponse
     *
     * @param goods 商品主信息
     * @return 数据响应
     */
    private GoodsResponse convertDetail(final Goods goods) {
        GoodsResponse response = new GoodsResponse();
        response.setId(goods.getId());
        response.setUnit(goods.getUnit());
        response.setGoodsState(goods.getGoodsState());
        response.setRecommend(goods.getRecommend());
        response.setBeginTime(goods.getBeginTime());
        response.setEndTime(goods.getEndTime());
        response.setGoodsType(goods.getGoodsType());
        // 商品状态
        response.setPublishStatus(goods.getPublishStatus());

        this.convert(response, goods, true);

        return response;
    }

    /**
     * 数据转换
     *
     * @param response 返回对象
     * @param goods    商品
     */
    private void convert(final GoodsResponse response, final Goods goods, final boolean detail) {

        // sku 名称
        GoodsSku sku = this.goodsSkuMapper.selectOne(new LambdaQueryWrapper<GoodsSku>()
                .eq(GoodsSku::getGoodsId, goods.getId()));
        response.setSkuId(sku.getId());
        response.setSkuName(sku.getSkuName());
        response.setWeight(sku.getWeight());
        response.setState(sku.getState());
        response.setSkuAmount(sku.getSkuAmount());
        response.setDiscountAmount(sku.getDiscountAmount());
        response.setSkuCode(sku.getSkuCode());
        if (detail) {
            response.setDescription(sku.getDescription());
        }

        // spu 分类
        if (Objects.nonNull(goods.getGoodsClassId())) {
            GoodsClass goodsClass = this.goodsClassMapper.selectById(goods.getGoodsClassId());
            GoodsSpu spu = this.goodsSpuMapper.selectOne(new LambdaQueryWrapper<GoodsSpu>()
                    .eq(GoodsSpu::getId, goodsClass.getSpuId())
                    .select(GoodsSpu::getId, GoodsSpu::getSpuName));

            response.setSpuName(spu.getSpuName().concat(" / ").concat(goodsClass.getClassName()));
            response.setGoodsClassId(Stream.of(spu.getId(), goodsClass.getId()).collect(Collectors.toList()));
        }

        // 商品图片集
        GoodsSkuImage skuImage = this.goodsSkuImageMapper.selectOne(new LambdaQueryWrapper<GoodsSkuImage>()
                .eq(GoodsSkuImage::getGoodsId, goods.getId())
                .select(GoodsSkuImage::getImages));
        response.setImages(JSON.parseArray(skuImage.getImages(), UploadDTO.class));

        // 商品库存
        GoodsSkuStock stock = this.goodsSkuStockMapper.selectOne(new LambdaQueryWrapper<GoodsSkuStock>()
                .eq(GoodsSkuStock::getGoodsId, goods.getId())
                .select(GoodsSkuStock::getStock));
        response.setStock(stock.getStock());
    }
}
