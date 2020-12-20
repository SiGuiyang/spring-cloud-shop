package quick.pager.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.client.BannerClient;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.goods.request.spu.GoodsSpuOtherRequest;
import quick.pager.shop.goods.response.spu.GoodsSpuTreeResponse;
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
@Slf4j
public class GoodsSpuServiceImpl extends ServiceImpl<GoodsSpuMapper, GoodsSpu> implements GoodsSpuService {

    @Autowired
    private GoodsClassMapper goodsClassMapper;
    @Autowired
    private BannerClient bannerClient;

    @Override
    public Response<Long> create(GoodsSpuSaveRequest request) {
        if (StringUtils.isBlank(request.getSpuName())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "spu名称不能为空！");
        }
        if (checkName(request.getSpuName(), null)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "spu名称已存在！");
        }
        GoodsSpu spu = this.conv(request);
        spu.setCreateTime(DateUtils.dateTime());
        spu.setDeleteStatus(Boolean.FALSE);
        if (this.baseMapper.insert(spu) > 0) {
            return Response.toResponse(spu.getId());
        }
        log.error("新增SPU失败 result = {}", JSON.toJSONString(request));
        return Response.toError(ResponseStatus.Code.FAIL_CODE, "新增SPU失败");
    }

    @Override
    public Response<Long> modify(GoodsSpuSaveRequest request) {
        if (StringUtils.isNotBlank(request.getSpuName()) && checkName(request.getSpuName(), request.getId())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "spu名称已存在！");
        }
        GoodsSpu spu = this.conv(request);
        this.baseMapper.updateById(spu);
        return Response.toResponse(spu.getId());
    }

    @Override
    public Response<Long> delete(final Long id) {
        int delete = this.baseMapper.deleteById(id);
        if (delete > 0) {
            return Response.toResponse(id);
        }
        log.error("删除SPU失败 id = {}", id);
        return Response.toError(ResponseStatus.Code.FAIL_CODE, "删除SPU失败");
    }

    @Override
    public Response<List<GoodsSpuResponse>> queryPage(GoodsSpuPageRequest request) {
        System.out.println(bannerClient.queryList(new BannerOtherRequest()));
        Response<List<GoodsSpu>> response = this.toPage(request.getPage(), request.getPageSize(), new LambdaQueryWrapper<GoodsSpu>()
                .likeRight(StringUtils.isNotBlank(request.getSpuName()), GoodsSpu::getSpuName, request.getSpuName())
                .orderByAsc(GoodsSpu::getSequence));

        return Response.toResponse(response.getData().stream().map(this::conv).collect(Collectors.toList()), response.getTotal());
    }

    @Override
    public Response<List<GoodsSpuResponse>> queryList(GoodsSpuOtherRequest request) {

        List<GoodsSpu> goodsSpus = this.baseMapper.selectList(new LambdaQueryWrapper<GoodsSpu>()
                .eq(StringUtils.isNotEmpty(request.getSpuName()), GoodsSpu::getSpuName, request.getSpuName())
                .like(StringUtils.isNotEmpty(request.getKeyword()), GoodsSpu::getSpuName, request.getKeyword()));
        return Response.toResponse(goodsSpus.stream().map(this::conv).collect(Collectors.toList()));
    }

    @Override
    public Response<List<GoodsSpuTreeResponse>> spuTree() {

        List<GoodsSpu> goodsSpus = this.baseMapper.selectList(Wrappers.emptyWrapper());
        return Response.toResponse(goodsSpus.stream().map(item -> {
            GoodsSpuTreeResponse response = new GoodsSpuTreeResponse();
            response.setId(item.getId());
            response.setName(item.getSpuName());
            List<GoodsClass> goodsClasses = goodsClassMapper.selectList(new LambdaQueryWrapper<GoodsClass>()
                    .eq(GoodsClass::getSpuId, item.getId()));
            response.setChildren(goodsClasses.stream().map(gc -> {
                GoodsSpuTreeResponse gcRes = new GoodsSpuTreeResponse();
                gcRes.setId(gc.getId());
                gcRes.setName(gc.getClassName());
                return gcRes;
            }).collect(Collectors.toList()));
            return response;
        }).collect(Collectors.toList()));
    }

    private GoodsSpu conv(GoodsSpuSaveRequest request) {
        GoodsSpu spu = new GoodsSpu();
        BeanCopier.create(request, spu).copy();
        return spu;
    }


    private GoodsSpuResponse conv(GoodsSpu spu) {
        GoodsSpuResponse response = new GoodsSpuResponse();
        BeanCopier.create(spu, response).copy();
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
                .eq(GoodsSpu::getSpuName, name));

        if (CollectionUtils.isEmpty(spus)) {
            return Boolean.FALSE;
        }

        return spus.stream()
                .filter(item -> Objects.isNull(id) ? Boolean.TRUE : IConsts.ZERO != item.getId().compareTo(id))
                .anyMatch(item -> item.getSpuName().equals(name));
    }
}
