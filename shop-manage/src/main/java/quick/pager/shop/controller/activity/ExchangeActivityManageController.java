package quick.pager.shop.controller.activity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quick.pager.shop.constants.Constants;
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
     * @param activityId 活动Id
     */
    @GetMapping("/exchange/{activityId}")
    public Response getExchangeActivity(@PathVariable("activityId") Long activityId){
        return exchangeActivityService.getExchangeActivity(activityId);
    }

    /**
     * 活动列表
     */
    @PostMapping(value = "/exchangeActivity/list")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response getExchangeActivitys(ExchangeActivityDTO dto) {
        return exchangeActivityService.getExchangeActivitys(dto);
    }

    /**
     * 活动新增
     */
    @PostMapping(value = "/exchangeActivity")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response addExchangeActivitys(ExchangeActivityDTO dto) {
        return exchangeActivityService.addExchangeActivitys(dto);
    }

    /**
     * 活动修改
     */
    @PutMapping(value = "/exchangeActivity")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response modifyExchangeActivitys(ExchangeActivityDTO dto) {
        return exchangeActivityService.modifyExchangeActivitys(dto);
    }


    /**
     * 列表
     */
    @PostMapping(value = "/exchange/rule/list")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response getExchangeActivityRules(ExchangeActivityDTO dto){
        dto.setEvent(Constants.Event.LIST);
        return exchangeActivityService.getExchangeActivityRules(dto);
    }

    /**
     * 规则新增
     */
    @PostMapping(value = "/exchange/rule")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response addExchangeActivityRules(ExchangeActivityDTO dto) {
        return exchangeActivityService.addExchangeActivityRules(dto);
    }

    /**
     * 规则修改
     */
    @PutMapping(value = "/exchange/rule")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response modifyExchangeActivityRules(ExchangeActivityDTO dto){
        return exchangeActivityService.modifyExchangeActivityRules(dto);
    }


    /**
     * 购买记录
     */
    @PostMapping("/exchange/purchase/history")
    public Response purchaseHistory(ExchangeActivityDTO dto) {
        return exchangeActivityService.purchaseHistory(dto);
    }


}
