package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.platform.request.SystemConfigDetailOtherRequest;
import quick.pager.shop.platform.request.SystemConfigDetailSaveRequest;
import quick.pager.shop.platform.response.SystemConfigDetailResponse;
import quick.pager.shop.service.SystemConfigDetailService;
import quick.pager.shop.user.response.Response;

/**
 * 系统配置
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.PLATFORM)
public class SystemConfigDetailController {

    @Autowired
    private SystemConfigDetailService systemConfigDetailService;

    /**
     * 创建配置
     */
    @PostMapping("/config/detail/create")
    public Response<Long> create(@RequestBody SystemConfigDetailSaveRequest request) {
        return systemConfigDetailService.create(request);
    }

    /**
     * 创建配置
     */
    @PutMapping("/config/detail/modify")
    public Response<Long> modify(@RequestBody SystemConfigDetailSaveRequest request) {
        if (Objects.isNull(request)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return systemConfigDetailService.modify(request);
    }

    /**
     * 查询配置列表，无分页
     */
    @GetMapping("/config/detail/list")
    public Response<List<SystemConfigDetailResponse>> queryList(SystemConfigDetailOtherRequest request) {

        return systemConfigDetailService.queryList(request);
    }

}
