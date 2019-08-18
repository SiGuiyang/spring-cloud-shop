package quick.pager.shop.controller.activity;

import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quick.pager.shop.BindingResultUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.ExchangeActivityDTO;
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
     * 获取活动
     *
     * @param activityId 活动Id
     */
    @GetMapping("/exchange/{activityId}")
    public Response getExchangeActivity(@PathVariable("activityId") Long activityId) {
        return exchangeActivityService.getExchangeActivity(activityId);
    }

    /**
     * 活动列表
     */
    @PostMapping(value = "/exchangeActivity/list")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response getExchangeActivitys(ExchangeActivityDTO dto) {
        return exchangeActivityService.getExchangeActivitys(dto);
    }

    /**
     * 活动新增
     */
    @PostMapping(value = "/exchangeActivity")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response addExchangeActivitys(@Valid ExchangeActivityDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return exchangeActivityService.addExchangeActivitys(dto);
    }

    /**
     * 活动修改
     */
    @PutMapping(value = "/exchangeActivity")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response modifyExchangeActivitys(@Valid ExchangeActivityDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return exchangeActivityService.modifyExchangeActivitys(dto);
    }


    /**
     * 列表
     */
    @PostMapping(value = "/exchange/rule/list")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response getExchangeActivityRules(@Valid ExchangeActivityDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        dto.setEvent(Constants.Event.LIST);
        return exchangeActivityService.getExchangeActivityRules(dto);
    }

    /**
     * 规则新增
     */
    @PostMapping(value = "/exchange/rule")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response addExchangeActivityRules(@Valid ExchangeActivityDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return exchangeActivityService.addExchangeActivityRules(dto);
    }

    /**
     * 规则修改
     */
    @PutMapping(value = "/exchange/rule")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response modifyExchangeActivityRules(@Valid ExchangeActivityDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return exchangeActivityService.modifyExchangeActivityRules(dto);
    }

    /**
     * 设置商品规则
     */
    @PutMapping("/exchange/goods/rule")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response goodsRule(@Valid ExchangeActivityDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return exchangeActivityService.goodsRule(dto);
    }

    /**
     * 查看换购商品的规则信息
     *
     * @param goodsId 商品Id
     */
    @GetMapping("/exchange/goods/rule/{activityId}/{goodsId}")
    public Response goodsRuleInfo(@PathVariable("activityId") Long activityId, @PathVariable("goodsId") Long goodsId) {
        return exchangeActivityService.goodsRuleInfo(activityId, goodsId);
    }

    /**
     * 购买记录
     */
    @PostMapping("/exchange/purchase/history")
    public Response purchaseHistory(@Valid ExchangeActivityDTO dto, BindingResult bindingResult) {
        BindingResultUtils.getFieldErrorMessage(bindingResult);
        return exchangeActivityService.purchaseHistory(dto);
    }


}
