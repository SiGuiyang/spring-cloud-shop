package quick.pager.shop.platform.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.platform.model.SystemConfig;
import quick.pager.shop.platform.request.SystemConfigOtherRequest;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.platform.service.SystemConfigService;
import quick.pager.shop.response.Response;
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

        SystemConfig systemConfig = this.convert(request);
        systemConfigService.save(systemConfig);

        return new Response<>(systemConfig.getId());
    }

    /**
     * 创建配置
     */
    @PutMapping("/config/modify")
    public Response<Long> modify(@RequestBody SystemConfigSaveRequest request) {
        SystemConfig systemConfig = this.convert(request);
        systemConfigService.updateById(systemConfig);

        return new Response<>(systemConfig.getId());
    }

    /**
     * 查询配置列表，无分页
     */
    @PostMapping("/config/queryList")
    public Response<List<SystemConfigResponse>> queryList(@RequestBody SystemConfigOtherRequest request) {
        List<SystemConfig> systemConfigs = systemConfigService.queryList(request);

        return new Response<>(Optional.ofNullable(systemConfigs).orElse(Collections.emptyList()).stream()
                .map(this::convert)
                .collect(Collectors.toList()));
    }

    /**
     * 查询配置列表分页
     */
    @PostMapping("/config/queryPage")
    public Response<List<SystemConfigResponse>> queryPage(@RequestBody SystemConfigPageRequest request) {

        Response<List<SystemConfig>> response = systemConfigService.queryPage(request);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }


    /**
     * SystemConfig -> SystemConfigResponse
     */
    private SystemConfigResponse convert(SystemConfig systemConfig) {
        SystemConfigResponse response = new SystemConfigResponse();
        BeanCopier.create(systemConfig, response).copy();
        return response;
    }

    /**
     * SystemConfigSaveRequest -> SystemConfig
     */
    private SystemConfig convert(SystemConfigSaveRequest request) {
        SystemConfig systemConfig = new SystemConfig();
        BeanCopier.create(request, systemConfig).copy();
        return systemConfig;
    }
}
