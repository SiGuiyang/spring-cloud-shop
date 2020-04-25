package quick.pager.shop.goods.service.impl;

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
import quick.pager.shop.activity.client.BannerClient;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.goods.mapper.GoodsClassBannerMapper;
import quick.pager.shop.goods.model.GoodsClass;
import quick.pager.shop.goods.mapper.GoodsClassMapper;
import quick.pager.shop.goods.model.GoodsClassBanner;
import quick.pager.shop.goods.request.classification.GoodsClassificationPageRequest;
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

    @Autowired
    private BannerClient bannerClient;
    @Autowired
    private GoodsClassBannerMapper goodsClassBannerMapper;

    @Override
    public Response<Long> create(GoodsClassificationSaveRequest request) {
        GoodsClass gc = this.convert(request);
        LocalDateTime dateTime = DateUtils.dateTime();
        gc.setCreateTime(dateTime);
        gc.setUpdateTime(dateTime);
        gc.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(gc);
        if (Objects.nonNull(request.getBannerId())) {
            insertGoodsClassBanner(request.getBannerId(), gc.getId(), dateTime, request.getUpdateUser(), request.getCreateUser());
        }
        return new Response<>(gc.getId());
    }

    @Override
    public Response<Long> modify(GoodsClassificationSaveRequest request) {
        GoodsClass gc = this.convert(request);
        this.baseMapper.updateById(gc);
        LambdaQueryWrapper<GoodsClassBanner> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GoodsClassBanner::getDeleteStatus, Boolean.FALSE);
        wrapper.eq(GoodsClassBanner::getClassificationId, request.getId());
        List<GoodsClassBanner> goodsClassBanners = goodsClassBannerMapper.selectList(wrapper);
        if (CollectionUtils.isNotEmpty(goodsClassBanners)) {
            goodsClassBanners.stream().findFirst().ifPresent(item -> {
                // 存在
                if (Objects.nonNull(request.getBannerId())) {
                    // 更新
                    if (0 != item.getBannerId().compareTo(request.getBannerId())) {
                        updateGoodsClassBanner(item.getId(), request.getBannerId(), gc.getId(), request.getUpdateUser());
                    } else { // 新增
                        insertGoodsClassBanner(request.getBannerId(), gc.getId(), DateUtils.dateTime(), request.getUpdateUser(), request.getCreateUser());
                    }
                }
            });
        } else {
            // 新增
            if (Objects.nonNull(request.getBannerId())) {
                insertGoodsClassBanner(request.getBannerId(), gc.getId(), DateUtils.dateTime(), request.getUpdateUser(), request.getCreateUser());
            }
        }
        return new Response<>(gc.getId());
    }

    @Override
    public Response<List<GoodsClassificationResponse>> queryPage(GoodsClassificationPageRequest request) {
        LambdaQueryWrapper<GoodsClass> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GoodsClass::getDeleteStatus, Boolean.FALSE);

        if (StringUtils.isNotBlank(request.getClassName())) {
            wrapper.likeRight(GoodsClass::getClassName, request.getClassName());
        }

        Response<List<GoodsClass>> response = this.toPage(request.getPage(), request.getPageSize(), wrapper);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList())
                , response.getTotal());
    }

    @Override
    public Response<List<GoodsClassificationResponse>> classificationTree() {
        LambdaQueryWrapper<GoodsClass> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GoodsClass::getDeleteStatus, Boolean.FALSE);
        wrapper.isNull(GoodsClass::getParentId);

        List<GoodsClass> goodsClasses = this.baseMapper.selectList(wrapper);

        return Response.toResponse(goodsClasses.stream().map(this::convert)
                .peek(item -> item.setChildren(this.toTree(item.getId())))
                .collect(Collectors.toList()), 0);
    }


    /**
     * model -> DTO
     */
    private GoodsClassificationResponse convert(GoodsClass gc) {
        GoodsClassificationResponse classification = new GoodsClassificationResponse();
        GoodsClassificationResponse response = BeanCopier.create(gc, classification).copy();

        if (Objects.nonNull(gc.getParentId())) {
            GoodsClass goodsClass = this.baseMapper.selectById(gc.getParentId());
            response.setParentClassName(goodsClass.getClassName());
        }
        // 查询是否关联banner
        LambdaQueryWrapper<GoodsClassBanner> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GoodsClassBanner::getDeleteStatus, Boolean.FALSE);
        wrapper.eq(GoodsClassBanner::getClassificationId, gc.getId());
        List<GoodsClassBanner> goodsClassBanners = goodsClassBannerMapper.selectList(wrapper);
        if (CollectionUtils.isNotEmpty(goodsClassBanners)) {
            goodsClassBanners.stream().findFirst().ifPresent(item -> {
                Response<BannerResponse> bannerResponse = bannerClient.queryByPk(item.getBannerId());
                BannerResponse responseData = bannerResponse.getData();
                if (Objects.nonNull(responseData)) {
                    response.setBannerId(item.getBannerId());
                    response.setBannerName(responseData.getTitle());
                }
            });
        }
        return response;
    }

    /**
     * 设置子节点孩子数据
     */
    private List<GoodsClassificationResponse> toTree(Long id) {

        LambdaQueryWrapper<GoodsClass> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GoodsClass::getDeleteStatus, Boolean.FALSE);
        wrapper.eq(GoodsClass::getParentId, id);
        List<GoodsClass> goodsClasses = this.baseMapper.selectList(wrapper);
        if (CollectionUtils.isNotEmpty(goodsClasses)) {
            return goodsClasses.stream().map(this::convert).collect(Collectors.toList());
        }
        return null;

    }

    /**
     * DTO -> db model
     */
    private GoodsClass convert(GoodsClassificationSaveRequest request) {
        return BeanCopier.create(request, new GoodsClass()).copy();
    }

    /**
     * 保存商品分类与banner
     *
     * @param bannerId         banner主键
     * @param classificationId 分类主键
     * @param dateTime         时间
     * @param updateUser       更新人
     * @param createUser       创建人
     */
    private void insertGoodsClassBanner(Long bannerId, Long classificationId, LocalDateTime dateTime, String updateUser, String createUser) {
        GoodsClassBanner goodsClassBanner = new GoodsClassBanner();
        goodsClassBanner.setBannerId(bannerId);
        goodsClassBanner.setClassificationId(classificationId);
        goodsClassBanner.setCreateTime(dateTime);
        goodsClassBanner.setUpdateTime(dateTime);
        goodsClassBanner.setUpdateUser(updateUser);
        goodsClassBanner.setCreateUser(createUser);
        goodsClassBanner.setDeleteStatus(Boolean.FALSE);
        goodsClassBannerMapper.insert(goodsClassBanner);
    }

    /**
     * 保存商品分类与banner
     *
     * @param bannerId         banner主键
     * @param classificationId 分类主键
     * @param updateUser       更新人
     */
    private void updateGoodsClassBanner(Long id, Long bannerId, Long classificationId, String updateUser) {
        GoodsClassBanner goodsClassBanner = new GoodsClassBanner();
        goodsClassBanner.setId(id);
        goodsClassBanner.setBannerId(bannerId);
        goodsClassBanner.setClassificationId(classificationId);
        goodsClassBanner.setUpdateTime(DateUtils.dateTime());
        goodsClassBanner.setUpdateUser(updateUser);
        goodsClassBannerMapper.updateById(goodsClassBanner);
    }

}
