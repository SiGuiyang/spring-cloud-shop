package quick.pager.shop.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.SystemConfigDetailMapper;
import quick.pager.shop.model.SystemConfigDetail;
import quick.pager.shop.platform.request.SystemConfigDetailOtherRequest;
import quick.pager.shop.platform.request.SystemConfigDetailSaveRequest;
import quick.pager.shop.platform.response.SystemConfigDetailResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * SystemConfigDetailServiceImpl
 *
 * @author siguiyang
 */
@Service
public class SystemConfigDetailServiceImpl extends ServiceImpl<SystemConfigDetailMapper, SystemConfigDetail> implements SystemConfigDetailService {

    @Override
    public Response<List<SystemConfigDetailResponse>> queryList(SystemConfigDetailOtherRequest request) {
        LambdaQueryWrapper<SystemConfigDetail> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(SystemConfigDetail::getDeleteStatus, Boolean.FALSE);

        if (StringUtils.isNotBlank(request.getConfigName())) {
            wrapper.likeRight(SystemConfigDetail::getConfigName, request.getConfigName());
        }
        if (StringUtils.isNotBlank(request.getConfigType())) {
            wrapper.eq(SystemConfigDetail::getConfigType, request.getConfigType());
        }
        if (StringUtils.isNotBlank(request.getConfigKey())) {
            wrapper.eq(SystemConfigDetail::getConfigKey, request.getConfigKey());
        }

        return Response.toResponse(this.baseMapper.selectList(wrapper).stream().map(this::convert).collect(Collectors.toList()));
    }

    @Override
    public Response<Long> create(SystemConfigDetailSaveRequest request) {
        SystemConfigDetail systemConfigDetail = this.convert(request);
        systemConfigDetail.setCreateTime(DateUtils.dateTime());
        systemConfigDetail.setDeleteStatus(Boolean.FALSE);
        systemConfigDetail.setConfigStatus(Boolean.FALSE);
        this.baseMapper.insert(systemConfigDetail);
        return Response.toResponse(systemConfigDetail.getId());
    }

    @Override
    public Response<Long> modify(SystemConfigDetailSaveRequest request) {
        SystemConfigDetail systemConfigDetail = this.convert(request);
        this.baseMapper.updateById(systemConfigDetail);
        return Response.toResponse(systemConfigDetail.getId());
    }

    /**
     * SystemConfigDetailSaveRequest -> SystemConfigDetail
     */
    private SystemConfigDetail convert(SystemConfigDetailSaveRequest request) {
        return BeanCopier.create(request, new SystemConfigDetail()).copy();
    }

    /**
     * SystemConfig -> SystemConfigResponse
     */
    private SystemConfigDetailResponse convert(SystemConfigDetail systemConfig) {
        return BeanCopier.create(systemConfig, new SystemConfigDetailResponse()).copy();
    }
}
