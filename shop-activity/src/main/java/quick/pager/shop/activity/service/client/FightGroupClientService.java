package quick.pager.shop.activity.service.client;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.activity.mapper.FightGroupGoodsMapper;
import quick.pager.shop.activity.mapper.FightGroupMapper;
import quick.pager.shop.activity.mapper.FightGroupMemberMapper;
import quick.pager.shop.activity.mapper.FightGroupRecordMapper;
import quick.pager.shop.activity.mapper.FightGroupRuleMapper;
import quick.pager.shop.model.activity.FightGroup;
import quick.pager.shop.model.activity.FightGroupGoods;
import quick.pager.shop.model.activity.FightGroupMember;
import quick.pager.shop.model.activity.FightGroupRecord;
import quick.pager.shop.model.activity.FightGroupRule;
import quick.pager.shop.model.feign.request.FightGroupRequest;
import quick.pager.shop.model.feign.response.FightGroupResponse;

/**
 * @author siguiyang
 */
@Service
@Slf4j
public class FightGroupClientService {

    @Autowired
    private FightGroupMapper fightGroupMapper;
    @Autowired
    private FightGroupRuleMapper fightGroupRuleMapper;
    @Autowired
    private FightGroupGoodsMapper fightGroupGoodsMapper;
    @Autowired
    private FightGroupRecordMapper fightGroupRecordMapper;
    @Autowired
    private FightGroupMemberMapper fightGroupMemberMapper;

    /**
     * 拼团活动列表
     *
     * @param activityName 活动名称
     * @param beginTime    开始时间
     * @param endTime      结束时间
     * @param page         页码
     * @param pageSize     页数
     */
    public Response fightGroup(String activityName, String beginTime, String endTime, Integer page, Integer pageSize) {

        PageHelper.startPage(page, pageSize);

        List<FightGroup> fightGroupList = fightGroupMapper.selectFightGroup(activityName, beginTime, endTime);

        List<FightGroupResponse> fightGroupResponseList = Lists.newArrayList();

        fightGroupList.forEach(fightGroup -> {

            FightGroupResponse fightGroupResponse = new FightGroupResponse();
            BeanUtils.copyProperties(fightGroup, fightGroupResponse);
            FightGroupRule rule = fightGroupRuleMapper.selectFightGroupRule(fightGroup.getId());
            FightGroupGoods goods = fightGroupGoodsMapper.selectFightGroupGoods(fightGroup.getId());

            if (!ObjectUtils.isEmpty(rule)) {
                fightGroupResponse.setRuleId(rule.getId());
            }
            if (!ObjectUtils.isEmpty(goods)) {
                fightGroupResponse.setGoodsId(goods.getGoodsId());
            }

            fightGroupResponseList.add(fightGroupResponse);

        });

        Response<List<FightGroupResponse>> response = new Response<>();
        PageInfo<FightGroupResponse> pageInfo = new PageInfo<>(fightGroupResponseList);

        response.setTotal(pageInfo.getTotal());
        response.setData(pageInfo.getList());
        return response;
    }

    /**
     * 拼团规则
     */
    public Response rule(FightGroupRequest request) {

        FightGroupRule rule = fightGroupRuleMapper.selectByPrimaryKey(request.getId());
        // 不存在则新增
        if (ObjectUtils.isEmpty(rule)) {
            rule = new FightGroupRule();
            rule.setDescription(request.getDescription());
            rule.setFightCount(request.getFightCount());
            rule.setPurchaseLimit(request.getPurchaseLimit());
            rule.setGroupId(request.getGroupId());
            rule.setDeleteStatus(false);
            rule.setCreateTime(new Date());
            fightGroupRuleMapper.insertSelective(rule);
        } else {
            FightGroupRule updateFightGroupRule = new FightGroupRule();
            updateFightGroupRule.setId(rule.getId());

            updateFightGroupRule.setDescription(request.getDescription());
            updateFightGroupRule.setFightCount(request.getFightCount());
            updateFightGroupRule.setPurchaseLimit(request.getPurchaseLimit());
            updateFightGroupRule.setGroupId(request.getGroupId());
            updateFightGroupRule.setDeleteStatus(request.getDeleteStatus());
            fightGroupRuleMapper.updateByPrimaryKeySelective(updateFightGroupRule);
        }

        return new Response();
    }

    /**
     * 规则详情
     *
     * @param id 活动Id t_fight_group id
     */
    public Response queryFightGroupRuleInfo(Long id) {
        FightGroup group = fightGroupMapper.selectByPrimaryKey(id);
        FightGroupRule rule = fightGroupRuleMapper.selectFightGroupRule(id);
        if (ObjectUtils.isEmpty(rule)) {
            rule = new FightGroupRule();
        }
        rule.setGroupId(group.getId());
        rule.setActivityName(group.getActivityName());
        return new Response<>(rule);
    }

    /**
     * 拼团商品
     */
    public Response goodsModify(FightGroupRequest request) {

        FightGroupGoods groupGoods = fightGroupGoodsMapper.selectFightGroupGoods(request.getId());
        // 没有则新增
        if (ObjectUtils.isEmpty(groupGoods)) {
            groupGoods.setGoodsId(request.getGoodsId());
            groupGoods.setGroupId(request.getId());
            groupGoods.setDeleteStatus(false);
            groupGoods.setCreateTime(new Date());
            fightGroupGoodsMapper.insertSelective(groupGoods);

        } else {
            FightGroupGoods updateFightGroupGoods = new FightGroupGoods();
            updateFightGroupGoods.setId(groupGoods.getId());


        }
        return new Response();
    }

    /**
     * 商品详情
     * fixme 暂定
     */
    public Response goodsInfo(Long id) {
        return new Response<>(fightGroupGoodsMapper.selectFightGroupGoods(id));
    }

    /**
     * 新增修改
     */
    private Response modifyFightGroupGoods(FightGroupRequest request) {
        FightGroupGoods goods = new FightGroupGoods();
        goods.setGoodsId(request.getGoodsId());
        goods.setGroupId(request.getGroupId());
        goods.setDeleteStatus(request.getDeleteStatus());
        if (Constants.Event.ADD.equals(request.getEvent())) {
            goods.setDeleteStatus(false);
            goods.setCreateTime(new Date());
            fightGroupGoodsMapper.insertSelective(goods);
        } else {
            goods.setId(request.getGoodsId());
            fightGroupGoodsMapper.updateByPrimaryKeySelective(goods);
        }
        return new Response();
    }

    /**
     * 成团记录列表
     */
    public Response records(Long groupId, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<FightGroupRecord> fightGroupRecords = fightGroupRecordMapper.selectFightGroupRecord(groupId);

        PageInfo<FightGroupRecord> pageInfo = new PageInfo<>(fightGroupRecords);

        Response<List<FightGroupRecord>> response = new Response<>();
        response.setData(pageInfo.getList());
        response.setTotal(pageInfo.getTotal());

        return response;
    }

    /**
     * 拼团成员
     */
    public Response members(Long recordId) {
        return new Response<>(fightGroupMemberMapper.selectFightGroupMember(recordId));
    }

    /**
     * 新增修改
     */
    public Response modify(FightGroupRequest request) {

        Response response = new Response();

        FightGroup group = new FightGroup();
        group.setActivityImg(request.getActivityImg());
        group.setActivityName(request.getActivityName());
        group.setEndTime(DateUtil.parse(request.getEndTime()));
        group.setBeginTime(DateUtil.parse(request.getBeginTime()));
        group.setDeleteStatus(request.getDeleteStatus());

        switch (request.getEvent()) {
            case Constants.Event.ADD:
                group.setCreateUser(request.getCreateUser());
                group.setCreateTime(new Date());
                group.setDeleteStatus(false);
                fightGroupMapper.insertSelective(group);
                break;
            case Constants.Event.MODIFY:
                group.setId(request.getId());
                fightGroupMapper.updateByPrimaryKeySelective(group);
                break;
            default:
                response = new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return response;
    }
}
