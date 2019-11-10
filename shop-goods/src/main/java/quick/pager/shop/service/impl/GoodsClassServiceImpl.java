package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.client.activity.BannerClient;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.mapper.GoodsClassMapper;
import quick.pager.shop.model.goods.GoodsClass;
import quick.pager.shop.response.GoodsClassTreeResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.GoodsClassService;
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
    public Response<List<ClassificationDTO>> getGoodsClass(String className, Integer page, Integer pageSize) {
        QueryWrapper<ClassificationDTO> qw = new QueryWrapper<>();

        qw.eq("t1.delete_status", Boolean.FALSE);
        if (!StringUtils.isEmpty(className)) {
            qw.likeRight("t1.class_name", className);
        }

        int count = this.baseMapper.selectGoodsClassCount(qw);
        List<ClassificationDTO> result = Collections.emptyList();
        if (0 < count) {
            result = this.baseMapper.selectGoodsClassList(new Page<>(page, pageSize), qw).getRecords();
        }
        return Response.toResponse(result, count);
    }

    @Override
    public Response<List<ClassificationDTO>> classificationTree() {
        QueryWrapper<GoodsClass> qw = new QueryWrapper<>();

        qw.eq("delete_status", Boolean.FALSE);
        qw.isNull("parent_id");
        List<GoodsClass> goodsClasses = this.baseMapper.selectList(qw);
        List<ClassificationDTO> collect = goodsClasses.stream().map(this::trans)
                .peek(m -> m.setChildren(this.transChildren(m.getId())))
                .collect(Collectors.toList());

        return Response.toResponse(collect, 0);
    }


    /**
     * model -> DTO
     */
    private ClassificationDTO trans(GoodsClass gc) {
        return BeanCopier.create(gc, new ClassificationDTO(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
                .copy();
    }

    /**
     * 设置子节点孩子数据
     */
    private List<ClassificationDTO> transChildren(Long id) {

        QueryWrapper<GoodsClass> qw = new QueryWrapper<>();

        qw.eq("delete_status", Boolean.FALSE);
        qw.eq("parent_id", id);
        List<GoodsClass> goodsClasses = this.baseMapper.selectList(qw);
        return goodsClasses.stream().map(this::trans).collect(Collectors.toList());

    }

}
