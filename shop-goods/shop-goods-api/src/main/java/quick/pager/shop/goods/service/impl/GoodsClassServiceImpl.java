package quick.pager.shop.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.activity.client.BannerClient;
import quick.pager.shop.goods.model.GoodsClass;
import quick.pager.shop.goods.mapper.GoodsClassMapper;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.goods.service.GoodsClassService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;

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
    private BannerClient bannerClient;

    @Override
    public Response<List<GoodsClassificationResponse>> getGoodsClass(String className, Integer page, Integer pageSize) {
        QueryWrapper<GoodsClass> qw = new QueryWrapper<>();

        qw.eq("t1.delete_status", Boolean.FALSE);
        if (!StringUtils.isEmpty(className)) {
            qw.likeRight("t1.class_name", className);
        }

        int count = this.baseMapper.selectGoodsClassCount(qw);
        List<GoodsClassificationResponse> result = Collections.emptyList();
        if (0 < count) {
            result = this.baseMapper.selectGoodsClassList(new Page<>(page, pageSize), qw).getRecords();
        }
        return Response.toResponse(result, count);
    }

    @Override
    public Response<List<GoodsClassificationResponse>> classificationTree() {
        QueryWrapper<GoodsClass> qw = new QueryWrapper<>();
        qw.eq("delete_status", Boolean.FALSE);
        qw.isNull("parent_id");

        List<GoodsClass> goodsClasses = this.baseMapper.selectList(qw);
        List<GoodsClassificationResponse> collect = goodsClasses.stream().map(this::convert)
                .peek(m -> m.setChildren(this.transChildren(m.getId())))
                .collect(Collectors.toList());

        return Response.toResponse(collect, 0);
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
    private List<GoodsClassificationResponse> transChildren(Long id) {

        GoodsClass gc = new GoodsClass();
        gc.setDeleteStatus(Boolean.FALSE);
        gc.setParentId(id);
        List<GoodsClass> goodsClasses = this.baseMapper.selectList(new QueryWrapper<>(gc));
        return goodsClasses.stream().map(this::convert).collect(Collectors.toList());

    }

}
