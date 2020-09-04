package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsPropertyGroupMapper;
import quick.pager.shop.mapper.GoodsPropertyMapper;
import quick.pager.shop.model.GoodsProperty;
import quick.pager.shop.model.GoodsPropertyGroup;
import quick.pager.shop.goods.request.property.GoodsPropertyPageRequest;
import quick.pager.shop.goods.request.property.GoodsPropertySaveRequest;
import quick.pager.shop.goods.response.property.GoodsPropertyResponse;
import quick.pager.shop.service.GoodsPropertyService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * <p>
 * 商品属性 服务实现类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Service
public class GoodsPropertyServiceImpl extends ServiceImpl<GoodsPropertyMapper, GoodsProperty> implements GoodsPropertyService {

    @Autowired
    private GoodsPropertyGroupMapper goodsPropertyGroupMapper;

    @Override
    public Response<List<GoodsPropertyResponse>> queryPage(GoodsPropertyPageRequest request) {

        Response<List<GoodsProperty>> page = this.toPage(request.getPage(), request.getPageSize(), new LambdaQueryWrapper<GoodsProperty>()
                .eq(GoodsProperty::getDeleteStatus, Boolean.FALSE)
                .eq(Objects.nonNull(request.getPropertyGroupId()), GoodsProperty::getPropertyGroupId, request.getPropertyGroupId())
                .likeRight(StringUtils.isNotBlank(request.getPropertyName()), GoodsProperty::getPropertyName, request.getPropertyName())
                .orderByDesc(GoodsProperty::getUpdateTime));

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()), page.getTotal());
    }


    @Override
    public Response<Long> create(GoodsPropertySaveRequest request) {
        GoodsProperty property = this.convert(request);
        property.setDeleteStatus(Boolean.FALSE);
        property.setCreateTime(DateUtils.dateTime());
        property.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.insert(property);
        return new Response<>(property.getId());
    }

    @Override
    public Response<Long> modify(GoodsPropertySaveRequest request) {
        GoodsProperty property = this.convert(request);
        property.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(property);
        return new Response<>(property.getId());
    }

    /**
     * GoodsProperty -> GoodsPropertyResponse
     *
     * @param property 属性
     * @return 属性
     */
    private GoodsPropertyResponse convert(GoodsProperty property) {
        GoodsPropertyResponse propertyResponse = new GoodsPropertyResponse();
        BeanCopier.create(property, propertyResponse).copy();
        GoodsPropertyGroup propertyGroup = goodsPropertyGroupMapper.selectById(property.getPropertyGroupId());
        propertyResponse.setPropertyGroupName(Objects.nonNull(propertyGroup) ? propertyGroup.getPropertyGroupName() : null);
        return propertyResponse;
    }

    /**
     * GoodsPropertySaveRequest -> GoodsProperty
     *
     * @param request 请求参数
     * @return 属性组
     */
    private GoodsProperty convert(GoodsPropertySaveRequest request) {
        return BeanCopier.create(request, new GoodsProperty()).copy();
    }
}
