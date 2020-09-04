package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.goods.enums.GoodsPublishStatusEnum;
import quick.pager.shop.goods.enums.GoodsTypeEnum;
import quick.pager.shop.mapper.GoodsBrandMapper;
import quick.pager.shop.mapper.GoodsClassMapper;
import quick.pager.shop.mapper.GoodsMapper;
import quick.pager.shop.mapper.GoodsPropertyGroupMapper;
import quick.pager.shop.mapper.GoodsSpuMapper;
import quick.pager.shop.model.Goods;
import quick.pager.shop.model.GoodsBrand;
import quick.pager.shop.model.GoodsClass;
import quick.pager.shop.model.GoodsPropertyGroup;
import quick.pager.shop.model.GoodsSpu;
import quick.pager.shop.goods.request.GoodsPageRequest;
import quick.pager.shop.goods.request.GoodsSaveRequest;
import quick.pager.shop.goods.response.GoodsResponse;
import quick.pager.shop.service.GoodsService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * GoodsServiceImpl
 *
 * @author siguiyang
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsBrandMapper goodsBrandMapper;
    @Autowired
    private GoodsClassMapper goodsClassMapper;
    @Autowired
    private GoodsSpuMapper goodsSpuMapper;
    @Autowired
    private GoodsPropertyGroupMapper goodsPropertyGroupMapper;

    @Override
    public Response<Long> create(GoodsSaveRequest request) {
        Goods goods = this.convert(request);
        goods.setPublishStatus(GoodsPublishStatusEnum.NONE_SHELF.getCode());
        goods.setCreateTime(DateUtils.dateTime());
        goods.setUpdateTime(DateUtils.dateTime());
        goods.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(goods);
        return new Response<>(goods.getId());
    }

    @Override
    public Response<Long> modify(GoodsSaveRequest request) {

        Goods goods = this.convert(request);
        goods.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(goods);
        return new Response<>(goods.getId());
    }

    @Override
    public Response<List<GoodsResponse>> queryPage(GoodsPageRequest request) {
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<Goods>()
                .eq(Goods::getDeleteStatus, Boolean.FALSE)
                .likeRight(StringUtils.isNotBlank(request.getName()), Goods::getName, request.getName())
                .eq(Objects.nonNull(request.getBrandId()), Goods::getBrandId, request.getBrandId())
                .eq(Objects.nonNull(request.getGcsId()), Goods::getGcsId, request.getGcsId())
                .eq(Objects.nonNull(request.getPublishStatus()), Goods::getPublishStatus, request.getPublishStatus())
                .eq(Objects.nonNull(request.getRecommend()), Goods::getRecommend, request.getRecommend())
                .eq(Objects.nonNull(request.getState()), Goods::getState, request.getState())
                .eq(Objects.nonNull(request.getSpuId()), Goods::getSpuId, request.getSpuId());

        Response<List<Goods>> page = this.toPage(request.getPage(), request.getPageSize(), wrapper);

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList())
                , page.getTotal());
    }

    /**
     * GoodsSaveRequest -> Goods
     *
     * @param request 参数
     * @return goods
     */
    private Goods convert(GoodsSaveRequest request) {
        Goods goods = new Goods();
        BeanCopier.copy(request, goods);
        return goods;
    }

    /**
     * Goods -> GoodsResponse
     *
     * @param goods 商品主信息
     * @return 数据响应
     */
    private GoodsResponse convert(Goods goods) {
        GoodsResponse response = new GoodsResponse();
        response.setId(goods.getId());
        response.setName(goods.getName());
        response.setUnit(goods.getUnit());
        response.setState(goods.getState());
        response.setRecommend(goods.getRecommend());
        response.setDeleteStatus(goods.getDeleteStatus());
        response.setDescription(goods.getDescription());
        response.setCreateTime(goods.getCreateTime());
        response.setUpdateTime(goods.getUpdateTime());
        response.setCreateUser(response.getCreateUser());
        response.setUpdateUser(goods.getUpdateUser());

        GoodsTypeEnum typeEnum = GoodsTypeEnum.parse(goods.getGoodsType());
        response.setGoodsType(goods.getGoodsType());
        response.setGoodsTypeName(null != typeEnum ? typeEnum.getName() : null);
        // 商品状态
        GoodsPublishStatusEnum statusEnum = GoodsPublishStatusEnum.parse(goods.getPublishStatus());
        response.setPublishStatus(goods.getPublishStatus());
        response.setPublishStatusName(null != statusEnum ? statusEnum.getDesc() : null);

        if (Objects.nonNull(goods.getBrandId())) {
            GoodsBrand brand = goodsBrandMapper.selectById(goods.getBrandId());
            response.setBrandId(goods.getBrandId());
            response.setBrandName(Objects.nonNull(brand) ? brand.getBrandName() : null);
        }

        if (Objects.nonNull(goods.getGcsId())) {
            GoodsClass goodsClass = goodsClassMapper.selectById(goods.getGcsId());
            response.setGcsId(goods.getGcsId());
            response.setGcsName(Objects.nonNull(goodsClass) ? goodsClass.getClassName() : null);
        }
        if (Objects.nonNull(goods.getGoodsPropertyGroupId())) {
            GoodsPropertyGroup propertyGroup = goodsPropertyGroupMapper.selectById(goods.getGoodsPropertyGroupId());
            response.setGoodsPropertyGroupId(goods.getGoodsPropertyGroupId());
            response.setGoodsPropertyGroupName(Objects.nonNull(propertyGroup) ? propertyGroup.getPropertyGroupName() : null);
        }
        if (Objects.nonNull(goods.getSpuId())) {
            GoodsSpu spu = goodsSpuMapper.selectById(goods.getSpuId());
            response.setSpuId(goods.getSpuId());
            response.setSpuName(Objects.nonNull(spu) ? spu.getSpuName() : null);
        }

        return response;
    }
}
