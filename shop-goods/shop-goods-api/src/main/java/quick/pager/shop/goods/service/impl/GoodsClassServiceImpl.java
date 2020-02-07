package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import quick.pager.shop.activity.client.BannerClient;
import quick.pager.shop.goods.model.GoodsClass;
import quick.pager.shop.goods.mapper.GoodsClassMapper;
import quick.pager.shop.goods.request.classification.GoodsClassificationRequest;
import quick.pager.shop.goods.request.classification.GoodsClassificationSaveRequest;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.goods.service.GoodsClassService;
import quick.pager.shop.service.impl.ServiceImpl;
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

//    @Autowired
//    private BannerClient bannerClient;

    @Override
    public Response<Long> create(GoodsClassificationSaveRequest request) {
        GoodsClass gc = this.convert(request);
        gc.setCreateTime(DateUtils.dateTime());
        gc.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(gc);
        return new Response<>(gc.getId());
    }

    @Override
    public Response<Long> modify(GoodsClassificationSaveRequest request) {
        GoodsClass gc = this.convert(request);
        this.baseMapper.updateById(gc);

        return new Response<>(gc.getId());
    }

    @Override
    public Response<List<GoodsClassificationResponse>> queryPage(GoodsClassificationRequest request) {
        QueryWrapper<GoodsClass> qw = new QueryWrapper<>();
        qw.eq("delete_status", Boolean.FALSE);

        if (StringUtils.isNotBlank(request.getClassName())) {
            qw.likeRight("class_name", request.getClassName());
        }

        Response<List<GoodsClass>> response = this.toPage(request.getPage(), request.getPageSize(), qw);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .peek(item -> item.setChildren(this.toTree(item.getId())))
                        .collect(Collectors.toList())
                , response.getTotal());
    }

    @Override
    public Response<List<GoodsClassificationResponse>> classificationTree() {
        QueryWrapper<GoodsClass> qw = new QueryWrapper<>();
        qw.eq("delete_status", Boolean.FALSE);
        qw.isNull("parent_id");

        List<GoodsClass> goodsClasses = this.baseMapper.selectList(qw);

        return Response.toResponse(goodsClasses.stream().map(this::convert)
                .peek(m -> m.setChildren(this.toTree(m.getId())))
                .collect(Collectors.toList()), 0);
    }


    /**
     * model -> DTO
     */
    private GoodsClassificationResponse convert(GoodsClass gc) {
        return BeanCopier.create(gc, new GoodsClassificationResponse()).copy();
    }

    /**
     * 设置子节点孩子数据
     */
    private List<GoodsClassificationResponse> toTree(Long id) {

        GoodsClass gc = new GoodsClass();
        gc.setDeleteStatus(Boolean.FALSE);
        gc.setParentId(id);
        List<GoodsClass> goodsClasses = this.baseMapper.selectList(new QueryWrapper<>(gc));
        return goodsClasses.stream().map(this::convert).collect(Collectors.toList());

    }

    /**
     * DTO -> db model
     */
    private GoodsClass convert(GoodsClassificationSaveRequest request) {
        return BeanCopier.create(request, new GoodsClass()).copy();
    }

}
