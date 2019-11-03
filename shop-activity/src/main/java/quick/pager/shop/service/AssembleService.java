package quick.pager.shop.service;

import quick.pager.shop.dto.activity.AssembleDTO;
import quick.pager.shop.response.AssembleResponse;
import quick.pager.shop.response.Response;

public interface AssembleService {

    /**
     * 拼团活动列表
     */
    Response list(AssembleDTO dto);

    /**
     * 修改拼团活动
     */
    Response modify(AssembleDTO dto);

    /**
     * 新增拼团活动
     */
    Response create(AssembleDTO dto);

    /**
     * 拼团活动规则
     *
     * @param activityId 活动主键
     */
    Response<AssembleResponse> ruleInfo(Long activityId);

    /**
     * 修改规则
     */
    Response modifyRule(AssembleDTO dto);

    /**
     * 设置拼团商品
     */
    Response assembleGoods(AssembleDTO dto);

    /**
     * 参与拼团成员
     */
    Response members(AssembleDTO dto);
}
