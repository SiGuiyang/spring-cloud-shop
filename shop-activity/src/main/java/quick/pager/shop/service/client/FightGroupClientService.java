package quick.pager.shop.service.client;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.client.GoodsClient;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mapper.FightGroupMapper;
import quick.pager.shop.response.FightGroupMemberResponse;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.mapper.FightGroupGoodsMapper;
import quick.pager.shop.mapper.FightGroupMemberMapper;
import quick.pager.shop.mapper.FightGroupRuleMapper;
import quick.pager.shop.dto.FightGroupDTO;
import quick.pager.shop.model.activity.FightGroup;
import quick.pager.shop.model.activity.FightGroupGoods;
import quick.pager.shop.model.activity.FightGroupRule;
import quick.pager.shop.utils.DateUtils;

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
    private FightGroupMemberMapper fightGroupMemberMapper;
    @Autowired
    private GoodsClient goodsClient;

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
        return Response.toResponse(fightGroupList);
    }

    /**
     * 拼团规则
     */
    public Response rule(FightGroupDTO request) {

        FightGroupRule rule = fightGroupRuleMapper.selectFightGroupRule(request.getActivityId());
        // 不存在则新增
        if (ObjectUtils.isEmpty(rule)) {
            rule = new FightGroupRule();
            rule.setDescription(request.getDescription());
            rule.setFightCount(request.getFightCount());
            rule.setPurchaseLimit(request.getPurchaseLimit());
            rule.setActivityId(request.getActivityId());
            rule.setDeleteStatus(false);
            rule.setCreateTime(new Date());
            fightGroupRuleMapper.insertSelective(rule);
        } else {
            FightGroupRule updateFightGroupRule = new FightGroupRule();
            updateFightGroupRule.setId(rule.getId());

            updateFightGroupRule.setDescription(request.getDescription());
            updateFightGroupRule.setFightCount(request.getFightCount());
            updateFightGroupRule.setPurchaseLimit(request.getPurchaseLimit());
            updateFightGroupRule.setActivityId(request.getActivityId());
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
        rule.setActivityId(group.getId());
        rule.setActivityName(group.getActivityName());
        return new Response<>(rule);
    }

    /**
     * 拼团商品
     */
    public Response goodsModify(FightGroupDTO request) {

        FightGroupGoods groupGoods = fightGroupGoodsMapper.selectFightGroupGoods(request.getId());
        // 没有则新增
        if (ObjectUtils.isEmpty(groupGoods)) {
            groupGoods.setGoodsId(request.getGoodsId());
            groupGoods.setActivityId(request.getId());
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
     * 新增修改
     */
    private Response modifyFightGroupGoods(FightGroupDTO request) {
        FightGroupGoods goods = new FightGroupGoods();
        goods.setGoodsId(request.getGoodsId());
        goods.setActivityId(request.getActivityId());
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
    public Response fightGroupMembers(Long activityId, String phone, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<FightGroupMemberResponse> responses = fightGroupMemberMapper.selectFightGroupRecord(activityId, phone);

        return Response.toResponse(responses);
    }

    /**
     * 新增修改
     */
    public Response modify(FightGroupDTO request) {

        Response response = new Response();

        FightGroup group = new FightGroup();
        if (!StringUtils.isEmpty(request.getActivityImg())) {
            group.setActivityImg(request.getActivityImg());
        }
        if (!StringUtils.isEmpty(request.getActivityName())) {

            group.setActivityName(request.getActivityName());
        }
        if (!StringUtils.isEmpty(request.getEndTime())) {
            group.setEndTime(DateUtil.parse(request.getEndTime()));
        }
        if (!StringUtils.isEmpty(request.getBeginTime())) {
            group.setBeginTime(DateUtil.parse(request.getBeginTime()));
        }
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

    public Response fightGroupGoodsInfo(Long activityId) {
        FightGroup fightGroup = fightGroupMapper.selectByPrimaryKey(activityId);
        if (ObjectUtils.isEmpty(fightGroup)) {
            return new Response(ResponseStatus.Code.FAIL_CODE, "未知拼团活动");
        }

        FightGroupGoods fightGroupGoods = fightGroupGoodsMapper.selectFightGroupGoods(activityId);
        if (ObjectUtils.isEmpty(fightGroupGoods)) {
            return new Response(ResponseStatus.Code.FAIL_CODE, "此活动未设置参与拼团的商品，请先设置拼团商品");
        }

        Response<GoodsResponse> goodsResponse = goodsClient.goodsInfo(fightGroupGoods.getGoodsId());
        // 查询成功
        if (ResponseStatus.Code.SUCCESS == goodsResponse.getCode()) {
            return new Response<>(goodsResponse.getData());
        }

        return new Response(goodsResponse.getCode(), goodsResponse.getMsg());
    }

    public Response setFightGroupGoods(Long activityId, Long goodsId) {

        // 检查活动
        FightGroup fightGroup = fightGroupMapper.selectByPrimaryKey(activityId);

        if (ObjectUtils.isEmpty(fightGroup)) {
            return new Response(ResponseStatus.Code.FAIL_CODE, "未知拼团活动");
        }

        // 检查规则
        FightGroupRule fightGroupRule = fightGroupRuleMapper.selectFightGroupRule(activityId);

        if (ObjectUtils.isEmpty(fightGroupRule)) {
            return new Response(ResponseStatus.Code.FAIL_CODE, "此活动未配置规则，请先配置规则");
        }

        int count = fightGroupGoodsMapper.selectCountByActivityIdAndGoodsId(activityId, goodsId);

        // 当前活动已配置了此商品则，返回提示
        if (count > 0) {
            return new Response(ResponseStatus.Code.FAIL_CODE, "此商品已在当前活动中");
        }

        FightGroupGoods fightGroupGoods = fightGroupGoodsMapper.selectFightGroupGoods(activityId);
        // 删除当前活动存在的商品，添加新的商品
        if (!ObjectUtils.isEmpty(fightGroupGoods)) {
            fightGroupGoods.setDeleteStatus(true);
            fightGroupGoodsMapper.updateByPrimaryKeySelective(fightGroupGoods);
        }

        // 新增拼团活动商品
        fightGroupGoods = new FightGroupGoods();

        fightGroupGoods.setDeleteStatus(false);
        fightGroupGoods.setActivityId(activityId);
        fightGroupGoods.setGoodsId(goodsId);
        fightGroupGoods.setRuleId(fightGroupRule.getId());
        fightGroupGoods.setCreateTime(DateUtils.now());
        fightGroupGoodsMapper.insertSelective(fightGroupGoods);

        return new Response();
    }

    public Response queryFightGroupGoods(Long activityId, Long goodsId) {
        int count = fightGroupGoodsMapper.selectCountByActivityIdAndGoodsId(activityId, goodsId);
        return count > 0 ? new Response() : new Response(ResponseStatus.Code.FAIL_CODE, "未参与此活动");
    }
}
