package quick.pager.shop.manage.controller.risk;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quick.pager.shop.constants.Constants;
import quick.pager.shop.manage.param.risk.BlackListPageParam;
import quick.pager.shop.manage.param.risk.BlackListSaveParam;
import quick.pager.shop.manage.service.risk.BlackListService;
import quick.pager.shop.response.Response;


/**
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    /**
     * 列表
     */
    @PreAuthorize("hasAuthority('PAGER_RISK_BLACKLIST')")
    @PostMapping(value = "/blackList/list")
    public Response blackLists(@Valid @RequestBody BlackListPageParam dto) {
        return blackListService.queryPage(dto);
    }

    /**
     * 新增
     */
    @PreAuthorize("hasAuthority('PAGER_RISK_BLACKLIST_CREATE')")
    @PostMapping(value = "/blackList")
    public Response addBlackLists(@Valid @RequestBody BlackListSaveParam dto) {
        return blackListService.create(dto);
    }

    /**
     * 修改
     */
    @PreAuthorize("hasAuthority('PAGER_RISK_BLACKLIST_MODIFY')")
    @PutMapping(value = "/blackList")
    public Response modifyBlackLists(@Valid @RequestBody BlackListSaveParam dto) {
        return blackListService.modify(dto);
    }

    /**
     * 删除
     */
    @PreAuthorize("hasAuthority('PAGER_ORDER_SALE')")
    @DeleteMapping(value = "/blackList/{id}")
    public Response delBlackLists(@PathVariable("id") Long id) {
        return blackListService.delBlackLists(id);
    }
}
