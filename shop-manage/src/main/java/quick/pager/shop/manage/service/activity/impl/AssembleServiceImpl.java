package quick.pager.shop.manage.service.activity.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.client.AssembleClient;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.activity.request.assemble.AssemblePageRequest;
import quick.pager.shop.activity.request.assemble.AssembleRuleSaveRequest;
import quick.pager.shop.activity.request.assemble.AssembleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.activity.response.assemble.AssembleResponse;
import quick.pager.shop.manage.param.assemble.AssemblePageParam;
import quick.pager.shop.manage.param.assemble.AssembleMemberParam;
import quick.pager.shop.manage.param.assemble.AssembleRuleSaveParam;
import quick.pager.shop.manage.param.assemble.AssembleSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.activity.AssembleService;
import quick.pager.shop.utils.BeanCopier;

@Service
public class AssembleServiceImpl implements AssembleService {

    @Autowired
    private AssembleClient assembleClient;

    @Override
    public Response<List<AssembleActivityResponse>> list(AssemblePageParam param) {
        AssemblePageRequest request = new AssemblePageRequest();
        request.setPage(param.getPage());
        request.setPageSize(param.getPageSize());
        request.setActivityName(param.getActivityName());
        request.setTimeRange(param.getTimeRange());
        return assembleClient.list(request);
    }

    @Override
    public Response<Long> modify(AssembleSaveParam param) {
        AssembleSaveRequest request = new AssembleSaveRequest();
        BeanCopier.create(param, request).copy();

        return assembleClient.modify(request);
    }

    @Override
    public Response<Long> create(AssembleSaveParam param) {
        AssembleSaveRequest request = new AssembleSaveRequest();
        BeanCopier.create(param, request).copy();
        return assembleClient.create(request);
    }

    @Override
    public Response<AssembleResponse> ruleInfo(Long activityId) {
        return assembleClient.ruleInfo(activityId);
    }

    @Override
    public Response<Long> modifyRule(AssembleRuleSaveParam param) {
        AssembleRuleSaveRequest request = new AssembleRuleSaveRequest();
        BeanCopier.create(param, request).copy();
        return assembleClient.modify(request);
    }

    @Override
    public Response<List<AssembleMemberResponse>> members(AssembleMemberParam param) {
        AssembleMemberPageRequest request = new AssembleMemberPageRequest();
        request.setActivityId(param.getActivityId());
        request.setPhone(param.getPhone());
        request.setPage(param.getPage());
        request.setPageSize(param.getPageSize());
        return assembleClient.members(request);
    }

    @Override
    public Response fightGroupGoodsInfo(Long activityId) {
        return assembleClient.assembleGoodsInfo(activityId);
    }

    @Override
    public Response setFightGroupGoods(AssembleMemberParam request) {
//        return assembleClient.assembleGoods(request.getActivityId(), request.getGoodsId());
        return null;
    }
}
