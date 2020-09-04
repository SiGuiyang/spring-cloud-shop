package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.GoodsBrandGroupMapper;
import quick.pager.shop.mapper.GoodsBrandMapper;
import quick.pager.shop.model.GoodsBrand;
import quick.pager.shop.model.GoodsBrandGroup;
import quick.pager.shop.goods.request.brand.GoodsBrandPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandResponse;
import quick.pager.shop.service.GoodsBrandService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * GoodsBrandServiceImpl
 *
 * @author siguiyang
 */
@Service
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandMapper, GoodsBrand> implements GoodsBrandService {

    @Autowired
    private GoodsBrandGroupMapper goodsBrandGroupMapper;

    @Override
    public Response<List<GoodsBrandResponse>> queryPage(GoodsBrandPageRequest request) {
        Response<List<GoodsBrand>> page = this.toPage(request.getPage(), request.getPageSize(), new LambdaQueryWrapper<GoodsBrand>()
                .eq(GoodsBrand::getDeleteStatus, Boolean.FALSE)
                .eq(StringUtils.isNotBlank(request.getBrandCode()), GoodsBrand::getBrandCode, request.getBrandCode())
                .likeRight(StringUtils.isNotBlank(request.getBrandName()), GoodsBrand::getBrandName, request.getBrandName())
                .orderByDesc(GoodsBrand::getUpdateTime));

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()), page.getTotal());
    }

    @Override
    public Response<Long> create(GoodsBrandSaveRequest request) {
        GoodsBrand brand = this.convert(request);
        brand.setCreateTime(DateUtils.dateTime());
        brand.setUpdateTime(DateUtils.dateTime());
        brand.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(brand);
        return new Response<>(brand.getId());
    }

    @Override
    public Response<Long> modify(GoodsBrandSaveRequest request) {
        GoodsBrand brand = this.convert(request);
        brand.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(brand);
        return new Response<>(brand.getId());
    }


    /**
     * request -> db model
     */
    private GoodsBrand convert(GoodsBrandSaveRequest request) {
        GoodsBrand brand = new GoodsBrand();
        BeanCopier.create(request, brand).copy();
        return brand;
    }

    /**
     * db model -> DTO
     */
    private GoodsBrandResponse convert(GoodsBrand goodsBrand) {
        GoodsBrandResponse response = new GoodsBrandResponse();
        BeanCopier.create(goodsBrand, response).copy();
        GoodsBrandGroup brandGroup = goodsBrandGroupMapper.selectById(goodsBrand.getBrandGroupId());
        response.setBrandGroupName(brandGroup.getBrandGroupName());
        return response;
    }
}
