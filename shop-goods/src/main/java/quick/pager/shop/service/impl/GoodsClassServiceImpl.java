package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.client.activity.BannerClient;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.mapper.GoodsClassMapper;
import quick.pager.shop.model.goods.GoodsClass;
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

        qw.eq("delete_status", Boolean.FALSE);
        if (!StringUtils.isEmpty(className)) {
            qw.likeLeft("class_name", className);
        }

        IPage<ClassificationDTO> iPage = this.baseMapper.selectGoodsClassList(new Page<>(page, pageSize), qw);

        return Response.toResponse(iPage);
    }

    @Override
    public Response<List<ClassificationDTO>> classificationTree() {
        QueryWrapper<GoodsClass> qw = new QueryWrapper<>();

        qw.eq("delete_status", Boolean.FALSE);
        qw.isNull("parent_id");
        List<GoodsClass> goodsClasses = this.baseMapper.selectList(qw);
        List<ClassificationDTO> collect = goodsClasses.stream().map(this::trans).peek(m -> {
            Long id = m.getId();
            m.setChildren(this.transChildren(id));
        }).collect(Collectors.toList());

        return Response.toResponse(collect, 0);
    }


    /**
     * model -> DTO
     */
    private ClassificationDTO trans(GoodsClass gc) {
        ClassificationDTO dto = new ClassificationDTO();
        BeanCopier.create(gc, dto, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true)).copy();
        return dto;
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
