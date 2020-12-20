package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mapper.GoodsSpuMapper;
import quick.pager.shop.model.GoodsClass;
import quick.pager.shop.mapper.GoodsClassMapper;
import quick.pager.shop.goods.request.classification.GoodsClassificationPageRequest;
import quick.pager.shop.goods.request.classification.GoodsClassificationSaveRequest;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.model.GoodsSpu;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.GoodsClassService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsClassServiceImpl extends ServiceImpl<GoodsClassMapper, GoodsClass> implements GoodsClassService {

    @Autowired
    private GoodsSpuMapper goodsSpuMapper;

    @Override
    public Response<Long> create(GoodsClassificationSaveRequest request) {
        if (StringUtils.isBlank(request.getClassName())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "分类名称不能为空！");
        }
        if (checkName(request.getClassName(), request.getSpuId(), null)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "分类名称已存在！");
        }
        GoodsClass gc = this.convert(request);
        LocalDateTime dateTime = DateUtils.dateTime();
        gc.setCreateTime(dateTime);
        gc.setUpdateTime(dateTime);
        gc.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(gc);
        return Response.toResponse(gc.getId());
    }

    @Override
    public Response<Long> modify(GoodsClassificationSaveRequest request) {
        if (StringUtils.isNotBlank(request.getClassName()) && checkName(request.getClassName(), request.getSpuId(), request.getId())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "分类名称已存在！");
        }
        GoodsClass gc = this.convert(request);
        gc.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(gc);
        return Response.toResponse(gc.getId());
    }

    @Override
    public Response<Long> delete(Long id) {
        if (this.baseMapper.deleteById(id) > 0) {
            return Response.toResponse(id);
        }
        return Response.toError(ResponseStatus.Code.FAIL_CODE, "删除商品失败");
    }

    @Override
    public Response<List<GoodsClassificationResponse>> queryPage(GoodsClassificationPageRequest request) {
        LambdaQueryWrapper<GoodsClass> wrapper = new LambdaQueryWrapper<GoodsClass>()
                .likeRight(StringUtils.isNotBlank(request.getClassName()), GoodsClass::getClassName, request.getClassName());

        Response<List<GoodsClass>> response = this.toPage(request.getPage(), request.getPageSize(), wrapper);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList())
                , response.getTotal());
    }

    @Override
    public Response<List<GoodsClassificationResponse>> queryBySpuId(final Long spuId) {

        List<GoodsClass> goodsClasses = this.baseMapper.selectList(new LambdaQueryWrapper<GoodsClass>().eq(GoodsClass::getSpuId, spuId).orderByAsc(GoodsClass::getSequence));

        return Response.toResponse(goodsClasses.stream().map(this::convert).collect(Collectors.toList()));
    }

    /**
     * model -> DTO
     */
    private GoodsClassificationResponse convert(GoodsClass gc) {
        GoodsClassificationResponse response = new GoodsClassificationResponse();
        if (Objects.nonNull(gc.getSpuId())) {
            GoodsSpu goodsSpu = goodsSpuMapper.selectById(gc.getSpuId());
            response.setSpuName(goodsSpu.getSpuName());
        }
        return BeanCopier.create(gc, response).copy();
    }

    /**
     * DTO -> db model
     */
    private GoodsClass convert(GoodsClassificationSaveRequest request) {
        return BeanCopier.create(request, new GoodsClass()).copy();
    }

    /**
     * 校验名称的唯一性
     *
     * @param name  分类名称
     * @param spuId spu主键
     * @param id    分类主键
     * @return true 表示已经存在，反之亦然
     */
    private Boolean checkName(final String name, final Long spuId, final Long id) {
        List<GoodsClass> classes = this.baseMapper.selectList(new LambdaQueryWrapper<GoodsClass>()
                .eq(GoodsClass::getSpuId, spuId)
                .eq(GoodsClass::getClassName, name));

        if (CollectionUtils.isEmpty(classes)) {
            return Boolean.FALSE;
        }

        return classes.stream()
                .filter(item -> Objects.isNull(id) || IConsts.ZERO != item.getId().compareTo(id))
                .anyMatch(item -> item.getClassName().equals(name));
    }

}
