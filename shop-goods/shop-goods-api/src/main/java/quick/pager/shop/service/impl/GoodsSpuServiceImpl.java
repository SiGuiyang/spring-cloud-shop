package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mapper.GoodsClassMapper;
import quick.pager.shop.mapper.GoodsSpuMapper;
import quick.pager.shop.model.GoodsClass;
import quick.pager.shop.model.GoodsSpu;
import quick.pager.shop.goods.request.spu.GoodsSpuPageRequest;
import quick.pager.shop.goods.request.spu.GoodsSpuSaveRequest;
import quick.pager.shop.goods.response.spu.GoodsSpuResponse;
import quick.pager.shop.service.GoodsSpuService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * <p>
 * 商品spu 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsSpuServiceImpl extends ServiceImpl<GoodsSpuMapper, GoodsSpu> implements GoodsSpuService {

    @Autowired
    private GoodsClassMapper goodsClassMapper;

    @Override
    public Response<Long> create(GoodsSpuSaveRequest request) {
        if (StringUtils.isBlank(request.getSpuName())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "spu名称不能为空！");
        }
        if (checkName(request.getSpuName(), null)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "spu名称已存在！");
        }
        GoodsSpu spu = this.conv(request);
        spu.setCreateTime(DateUtils.dateTime());
        spu.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(spu);
        return new Response<>(spu.getId());
    }

    @Override
    public Response<Long> modify(GoodsSpuSaveRequest request) {
        if (StringUtils.isNotBlank(request.getSpuName()) && checkName(request.getSpuName(), request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "spu名称已存在！");
        }
        GoodsSpu spu = this.conv(request);
        this.baseMapper.updateById(spu);
        return new Response<>(spu.getId());
    }

    @Override
    public Response<List<GoodsSpuResponse>> queryPage(GoodsSpuPageRequest request) {

        Response<List<GoodsSpu>> response = this.toPage(request.getPage(), request.getPageSize(), new LambdaQueryWrapper<GoodsSpu>()
                .eq(GoodsSpu::getDeleteStatus, Boolean.FALSE)
                .likeRight(StringUtils.isNotBlank(request.getSpuName()), GoodsSpu::getSpuName, request.getSpuName())
                .orderByDesc(GoodsSpu::getUpdateTime));

        return Response.toResponse(response.getData().stream().map(this::conv).collect(Collectors.toList()), response.getTotal());
    }

    private GoodsSpu conv(GoodsSpuSaveRequest request) {
        GoodsSpu spu = new GoodsSpu();
        BeanCopier.create(request, spu).copy();
        return spu;
    }


    private GoodsSpuResponse conv(GoodsSpu spu) {
        GoodsSpuResponse response = new GoodsSpuResponse();
        BeanCopier.create(spu, response).copy();
        if (Objects.nonNull(spu.getClassificationId())) {
            GoodsClass goodsClass = goodsClassMapper.selectById(spu.getClassificationId());
            response.setClassificationName(Objects.nonNull(goodsClass) ? goodsClass.getClassName() : null);
        }
        return response;
    }


    /**
     * 校验名称的唯一性
     *
     * @param name spu名称
     * @param id   spu主键
     * @return true 表示已经存在，反之亦然
     */
    private Boolean checkName(final String name, final Long id) {
        List<GoodsSpu> spus = this.baseMapper.selectList(new LambdaQueryWrapper<GoodsSpu>()
                .eq(GoodsSpu::getDeleteStatus, Boolean.FALSE)
                .eq(GoodsSpu::getSpuName, name));

        if (CollectionUtils.isEmpty(spus)) {
            return Boolean.FALSE;
        }

        return spus.stream().filter(item -> {
            if (Objects.isNull(id)) {
                return Boolean.TRUE;
            } else {
                return IConsts.ZERO != item.getId().compareTo(id);
            }
        }).anyMatch(item -> item.getSpuName().equals(name));
    }
}
