package quick.pager.shop.controller.system;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.param.system.SysUserDownloadParam;
import quick.pager.shop.param.system.SysUserPageParam;
import quick.pager.shop.response.system.SysUserDownloadResponse;
import quick.pager.shop.response.system.SysUserResponse;
import quick.pager.shop.service.system.SysUserService;
import quick.pager.shop.param.system.SysUserSaveParam;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.util.AuthUtils;

/**
 * 系统管理
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class SystemController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 系统登陆用户吧信息
     */
    @PostMapping("/system/adminInfo")
    public Response sysUserInfo() {
        return sysUserService.adminInfo(AuthUtils.getPrincipal().getName());
    }

    /**
     * 退出
     */
    @PostMapping("/logout")
    public Response logout() {
        return Response.toResponse();
    }

    /**
     * 系统用户列表
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_USER')")
    @PostMapping("/system/user/page")
    public Response<List<SysUserResponse>> page(@RequestBody SysUserPageParam param) {
        return sysUserService.queryPage(param);
    }

    /**
     * 新增系统用户
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_USER_CREATE')")
    @PostMapping("/system/user/create")
    public Response<Long> create(@RequestBody SysUserSaveParam param) {

        return sysUserService.create(param);
    }

    /**
     * 修改系统用户
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_USER_MODIFY')")
    @PutMapping("/system/user/modify")
    public Response<Long> modify(@RequestBody SysUserSaveParam dto) {

        return sysUserService.modify(dto);
    }

    /**
     * 导出
     *
     * @param param 请求参数
     */
    @PostMapping("/system/user/download")
    public void download(@RequestBody SysUserDownloadParam param, HttpServletResponse response) throws Exception {

        List<SysUserDownloadResponse> responseList = sysUserService.queryDownload(param.getIds());

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(param.getFileName(), "UTF-8"));

        EasyExcel.write(response.getOutputStream(), SysUserDownloadResponse.class).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).sheet("用户信息").doWrite(responseList);
    }
}
