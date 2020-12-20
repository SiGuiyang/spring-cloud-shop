package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.risk.request.WhiteBlacklistPageRequest;
import quick.pager.shop.risk.request.WhiteBlacklistSaveRequest;
import quick.pager.shop.risk.response.WhiteBlacklistResponse;
import quick.pager.shop.service.WhitelistService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;


/**
 * 白名单
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.RISK)
public class WhitelistController {

    @Autowired
    private WhitelistService whitelistService;

    /**
     * 列表
     */
    @PostMapping(value = "/whitelist/page")
    public Response<List<WhiteBlacklistResponse>> list(@RequestBody WhiteBlacklistPageRequest request) {
        return whitelistService.queryPage(request);
    }

    /**
     * 新增
     */
    @PostMapping(value = "/whitelist")
    public Response<Long> create(@RequestBody WhiteBlacklistSaveRequest request) {
        return whitelistService.create(request);
    }

    /**
     * 修改
     */
    @PutMapping(value = "/whitelist")
    public Response<Long> modify(@RequestBody WhiteBlacklistSaveRequest request) {

        Assert.isTrue(Objects.nonNull(request.getId()), () -> ResponseStatus.PARAMS_EXCEPTION);

        return whitelistService.modify(request);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/whitelist/{id}")
    public Response<Long> delete(@PathVariable("id") Long id) {
        return whitelistService.delete(id);
    }
}
