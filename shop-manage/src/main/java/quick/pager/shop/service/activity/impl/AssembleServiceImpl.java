package quick.pager.shop.service.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.activity.AssembleClient;
import quick.pager.shop.dto.activity.AssembleDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.AssembleService;

@Service
public class AssembleServiceImpl implements AssembleService {

    @Autowired
    private AssembleClient assembleClient;

    @Override
    public Response list(AssembleDTO dto) {
        return assembleClient.list(dto);
    }

    @Override
    public Response modify(AssembleDTO dto) {
        return assembleClient.modify(dto);
    }

    @Override
    public Response create(AssembleDTO dto) {
        return assembleClient.create(dto);
    }

    @Override
    public Response ruleInfo(Long activityId) {
        return assembleClient.ruleInfo(activityId);
    }

    @Override
    public Response modifyRule(AssembleDTO dto) {
        return assembleClient.modifyRule(dto);
    }

    @Override
    public Response members(AssembleDTO dto) {
        return assembleClient.members(dto);
    }

    @Override
    public Response fightGroupGoodsInfo(Long activityId) {
        return assembleClient.assembleGoodsInfo(activityId);
    }

    @Override
    public Response setFightGroupGoods(AssembleDTO request) {
        return assembleClient.assembleGoods(request.getActivityId(), request.getGoodsId());
    }
}
