package quick.pager.shop.controller.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.request.AppNativeMessageRequest;
import quick.pager.shop.user.response.NativeMessageResponse;
import quick.pager.shop.service.NativeMessageService;
import quick.pager.shop.util.AuthUtils;

/**
 * 站内消息
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class AppNativeMessageController {

    @Autowired
    private NativeMessageService nativeMessageService;

    /**
     * 站内信未读个数
     *
     */
    @PostMapping("/app/message/count")
    public Response<Integer> count() {
        // 获取当前登录人
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return nativeMessageService.count(principal.getId());
    }

    /**
     * 站内消息列表
     *
     * @param page   页码
     */
    @PostMapping("/app/message/{page}")
    public Response<List<NativeMessageResponse>> message( @PathVariable("page") Integer page) {
        // 获取当前登录人
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return nativeMessageService.queryAppPage(principal.getId(), page);
    }

    /**
     * 站内消息操作 删除
     */
    @PostMapping("/app/message/delete")
    public Response delete(@RequestBody AppNativeMessageRequest param) {
        return nativeMessageService.delete(param.getUserId(), param.getMessageIds());
    }

    /**
     * 站内消息操作 删除
     * 批量设置已读消息
     */
    @PostMapping("/app/message/modify")
    public Response modify(@RequestBody AppNativeMessageRequest request) {
        // 获取当前登录人
        return nativeMessageService.modify(request.getMessageIds());
    }

    /**
     * 站内信详情¬
     *
     * @param id 站内信主键
     */
    @PostMapping("/app/message/{id}/info")
    public Response<NativeMessageResponse> info(@PathVariable("id") Long id) {
        return nativeMessageService.info(id);
    }
}
