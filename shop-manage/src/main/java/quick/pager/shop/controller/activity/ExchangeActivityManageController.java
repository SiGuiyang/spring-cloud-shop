package quick.pager.shop.controller.activity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.ExchangeActivityService;


/**
 * 满赠换购
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class ExchangeActivityManageController {

    @Autowired
    private ExchangeActivityService exchangeActivityService;

    /**
     * 活动列表
     */
    @PostMapping(value = "/activity/exchange/list")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response list(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityService.list(dto);
    }

    /**
     * 获取活动
     *
     * @param activityId 活动Id
     */
    @GetMapping("/activity/exchange/{activityId}")
    public Response info(@PathVariable("activityId") Long activityId) {
        return exchangeActivityService.info(activityId);
    }

    /**
     * 活动新增
     */
    @PostMapping(value = "/activity/exchange/create")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response create(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityService.create(dto);
    }

    /**
     * 活动修改
     */
    @PutMapping(value = "/activity/exchange/modify")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response modify(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityService.modify(dto);
    }


    /**
     * 列表
     */
    @PostMapping(value = "/activity/exchange/rule/list")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response rules(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityService.rules(dto);
    }

    /**
     * 规则新增
     */
    @PostMapping(value = "/activity/exchange/rule/create")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response createRule(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityService.createRule(dto);
    }

    /**
     * 规则修改
     */
    @PutMapping(value = "/activity/exchange/rule/modify")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response modifyRule(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityService.modifyRule(dto);
    }

    /**
     * 设置商品规则
     */
    @PutMapping("/activity/exchange/goods/rule")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response goodsRule(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityService.goodsRule(dto);
    }

    /**
     * 查看换购商品的规则信息
     *
     * @param goodsId 商品Id
     */
    @GetMapping("/activity/exchange/goods/rule/{activityId}/{goodsId}")
    public Response goodsRuleInfo(@PathVariable("activityId") Long activityId, @PathVariable("goodsId") Long goodsId) {
        return exchangeActivityService.goodsRuleInfo(activityId, goodsId);
    }

    /**
     * 购买记录
     */
    @PostMapping("/activity/exchange/purchase/history")
    public Response purchaseHistory(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityService.purchaseHistory(dto);
    }


}
