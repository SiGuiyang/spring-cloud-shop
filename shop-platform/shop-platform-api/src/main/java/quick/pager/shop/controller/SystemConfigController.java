package quick.pager.shop.controller;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.model.SystemConfig;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.service.SystemConfigService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;

/**
 * 系统配置
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.PLATFORM)
public class SystemConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    /**
     * 创建配置
     */
    @PostMapping("/config/create")
    public Response<Long> create(@RequestBody SystemConfigSaveRequest request) {
        return systemConfigService.create(request);
    }

    /**
     * 创建配置
     */
    @PutMapping("/config/modify")
    public Response<Long> modify(@RequestBody SystemConfigSaveRequest request) {
        if (Objects.isNull(request)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return systemConfigService.modify(request);
    }

    /**
     * 查询配置列表，无分页
     */
    @GetMapping("/config/list")
    public Response<List<SystemConfigResponse>> queryList(SystemConfigOtherRequest request) {
        List<SystemConfig> systemConfigs = systemConfigService.queryList(request);

        return Response.toResponse(Optional.ofNullable(systemConfigs).orElse(Collections.emptyList()).stream()
                .map(this::convert)
                .collect(Collectors.toList()));
    }

    /**
     * 查询配置列表分页
     */
    @PostMapping("/config/page")
    public Response<List<SystemConfigResponse>> queryPage(@RequestBody SystemConfigPageRequest request) {

        Response<List<SystemConfig>> response = systemConfigService.queryPage(request);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }

    /**
     * 手动刷新系统配置redis缓存
     */
    @GetMapping("/config/refresh")
    public Response<String> refresh() {

        systemConfigService.executeTask();

        return Response.toResponse();
    }

    /**
     * SystemConfig -> SystemConfigResponse
     */
    private SystemConfigResponse convert(SystemConfig systemConfig) {
        SystemConfigResponse response = new SystemConfigResponse();
        BeanCopier.create(systemConfig, response).copy();
        return response;
    }


}
