package quick.pager.shop.service.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.dto.FightGroupDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.FightGroupService;

@Service
public class FightGroupServiceImpl implements FightGroupService {

    @Autowired
    private ActivityClient activityClient;

    @Override
    public Response fightGroupActivityList(FightGroupDTO dto) {
        return activityClient.fightGroupActivityList(dto);
    }

    @Override
    public Response modifyFightGroupActivity(FightGroupDTO dto) {
        return activityClient.modifyFightGroupActivity(dto);
    }

    @Override
    public Response addFightGroupActivity(FightGroupDTO dto) {
        return activityClient.addFightGroupActivity(dto);
    }

    @Override
    public Response fightGroupActivityRuleInfo(Long activityId) {
        return activityClient.fightGroupActivityRuleInfo(activityId);
    }

    @Override
    public Response modifyFightGroupRule(FightGroupDTO dto) {
        return activityClient.modifyFightGroupRule(dto);
    }

    @Override
    public Response fightGroupRecord(FightGroupDTO dto) {
        return activityClient.fightGroupRecords(dto);
    }

    @Override
    public Response fightGroupGoodsInfo(Long activityId) {
        return activityClient.fightGroupGoodsInfo(activityId);
    }

    @Override
    public Response setFightGroupGoods(FightGroupDTO request) {
        return activityClient.setFightGroupGoods(request.getActivityId(), request.getGoodsId());
    }
}
