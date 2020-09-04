package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.risk.request.BlackListPageRequest;
import quick.pager.shop.risk.request.BlackListSaveRequest;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.BlackListService;


/**
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.RISK)
public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    /**
     * 列表
     */
    @PostMapping(value = "/blackList/list")
    public Response list(@RequestBody BlackListPageRequest request) {
        return blackListService.queryPage();
    }

    /**
     * 新增
     */
    @PostMapping(value = "/blackList")
    public Response create(@RequestBody BlackListSaveRequest request) {
        return blackListService.create();
    }

    /**
     * 修改
     */
    @PutMapping(value = "/blackList")
    public Response modify(@RequestBody BlackListSaveRequest request) {
        return blackListService.modify();
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/blackList/{id}")
    public Response delete(@PathVariable("id") Long id) {
        return blackListService.modify();
    }
}
