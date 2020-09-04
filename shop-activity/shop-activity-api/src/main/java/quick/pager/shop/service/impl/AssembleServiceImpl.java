package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.model.AssembleActivity;
import quick.pager.shop.model.AssembleActivityMember;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.activity.request.assemble.AssemblePageRequest;
import quick.pager.shop.activity.request.assemble.AssembleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.mapper.AssembleActivityMemberMapper;
import quick.pager.shop.mapper.AssembleActivityMapper;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.AssembleService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

@Service
public class AssembleServiceImpl extends ServiceImpl<AssembleActivityMapper, AssembleActivity> implements AssembleService {

    @Autowired
    private AssembleActivityMemberMapper assembleActivityMemberMapper;

    @Override
    public Response<List<AssembleActivityResponse>> queryPage(AssemblePageRequest request) {

        Response<List<AssembleActivity>> response = this.toPage(request.getPage(), request.getPageSize(), new LambdaQueryWrapper<AssembleActivity>()
                .likeRight(StringUtils.isNotBlank(request.getActivityName()), AssembleActivity::getActivityName, request.getActivityName())
                .between(CollectionUtils.isNotEmpty(request.getTimeRange()), AssembleActivity::getBeginTime, request.getTimeRange().get(0), request.getTimeRange().get(1))
                .orderByDesc(AssembleActivity::getUpdateTime));

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }

    @Override
    public Response<Long> modify(AssembleSaveRequest request) {
        AssembleActivity assembleActivity = this.conv(request);
        this.baseMapper.updateById(assembleActivity);
        return new Response<>(request.getId());
    }

    @Override
    public Response<Long> create(AssembleSaveRequest request) {

        AssembleActivity assembleActivity = this.conv(request);
        assembleActivity.setServerStatus(Boolean.FALSE);
        assembleActivity.setCreateTime(DateUtils.dateTime());
        assembleActivity.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(assembleActivity);
        return new Response<>(assembleActivity.getId());
    }

//    @Override
//    public Response assembleGoods(AssembleDTO request) {
//
//        AssembleActivityGoods activityGoods = BeanCopier.create(request, new AssembleActivityGoods(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
//                .copy();
//        QueryWrapper<AssembleActivityGoods> qw = new QueryWrapper<>();
//        qw.eq("activity_id", request.getActivityId());
//        qw.eq("delete_status", Boolean.FALSE);
//        AssembleActivityGoods goods = assembleActivityGoodsMapper.selectOne(qw);
//
//        if (null == goods) {
//            activityGoods.setCreateTime(DateUtils.dateTime());
//            assembleActivityGoodsMapper.insert(activityGoods);
//
//        } else {
//            assembleActivityGoodsMapper.updateById(goods);
//        }
//
//        return new Response();
//    }

    @Override
    public Response<List<AssembleMemberResponse>> members(AssembleMemberPageRequest request) {

        LambdaQueryWrapper<AssembleActivityMember> qw = new LambdaQueryWrapper<AssembleActivityMember>()
                .eq(AssembleActivityMember::getDeleteStatus, Boolean.FALSE)
                .eq(Objects.nonNull(request.getActivityId()), AssembleActivityMember::getActivityId, request.getActivityId())
                .eq(StringUtils.isNotEmpty(request.getPhone()), AssembleActivityMember::getPhone, request.getPhone())
                .orderByDesc(AssembleActivityMember::getUpdateTime);

        int total = assembleActivityMemberMapper.selectCount(qw);
        List<AssembleMemberResponse> result = Collections.emptyList();
        if (0 < total) {

            List<AssembleActivityMember> records = assembleActivityMemberMapper.selectPage(new Page<>(request.getPage(), request.getPageSize(), false), qw)
                    .getRecords();
            result = records.stream().map(this::convert).collect(Collectors.toList());
        }
        return Response.toResponse(result, total);
    }

    /**
     * AssembleSaveRequest -> AssembleActivity
     */
    private AssembleActivity conv(AssembleSaveRequest request) {
        return BeanCopier.create(request, new AssembleActivity()).copy();
    }

    /**
     * activity -> AssembleActivityResponse
     */
    private AssembleActivityResponse convert(AssembleActivity activity) {
        return BeanCopier.create(activity, new AssembleActivityResponse()).copy();
    }

    /**
     * AssembleActivityMember -> AssembleMemberResponse
     *
     * @param member 成员
     */
    private AssembleMemberResponse convert(AssembleActivityMember member) {
        AssembleMemberResponse response = new AssembleMemberResponse();
        BeanCopier.copy(member, response);
        return response;
    }
}
