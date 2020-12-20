package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.model.AssembleActivityMember;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.mapper.AssembleActivityMemberMapper;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.service.ActivityService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.AssembleService;
import quick.pager.shop.utils.BeanCopier;

@Service
public class AssembleServiceImpl implements AssembleService {

    @Autowired
    private AssembleActivityMemberMapper assembleActivityMemberMapper;
    @Autowired
    private ActivityService activityService;

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

        if (activityService.nonExists(request.getActivityId())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "活动不存在");
        }

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
