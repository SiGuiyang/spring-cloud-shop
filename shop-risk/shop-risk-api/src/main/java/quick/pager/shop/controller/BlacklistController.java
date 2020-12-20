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
import org.springframework.web.multipart.MultipartFile;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.risk.request.WhiteBlacklistPageRequest;
import quick.pager.shop.risk.request.WhiteBlacklistSaveRequest;
import quick.pager.shop.risk.response.WhiteBlacklistResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.BlacklistService;
import quick.pager.shop.utils.Assert;


/**
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.RISK)
public class BlacklistController {

    @Autowired
    private BlacklistService blacklistService;

    /**
     * 列表
     */
    @PostMapping(value = "/blacklist/page")
    public Response<List<WhiteBlacklistResponse>> list(@RequestBody WhiteBlacklistPageRequest request) {
        return blacklistService.queryPage(request);
    }

    /**
     * 新增
     */
    @PostMapping(value = "/blacklist")
    public Response<Long> create(@RequestBody WhiteBlacklistSaveRequest request) {
        return blacklistService.create(request);
    }

    /**
     * 修改
     */
    @PutMapping(value = "/blacklist")
    public Response<Long> modify(@RequestBody WhiteBlacklistSaveRequest request) {

        Assert.isTrue(Objects.nonNull(request.getId()), () -> ResponseStatus.PARAMS_EXCEPTION);

        return blacklistService.modify(request);
    }

    /**
     * 批量添加黑名单
     *
     * @param file 文件
     */
    @PostMapping("/blacklist/upload")
    public Response<Long> upload(MultipartFile file) {
        return Response.toResponse();
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/blacklist/{id}")
    public Response<Long> delete(@PathVariable("id") Long id) {
        return blacklistService.delete(id);
    }
}
