package quick.pager.shop.controller.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.param.AppNativeMessageParam;
import quick.pager.shop.user.response.NativeMessageResponse;
import quick.pager.shop.service.NativeMessageService;

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
     * @param userId 当前登陆人主键
     */
    @PostMapping("/app/message/{userId}/count")
    public Response<Integer> count(@PathVariable("userId") Long userId) {
        return nativeMessageService.count(userId);
    }

    /**
     * 站内消息列表
     *
     * @param userId 用户主键
     * @param page   页码
     */
    @PostMapping("/app/message/{userId}/{page}")
    public Response<List<NativeMessageResponse>> message(@PathVariable("userId") Long userId, @PathVariable("page") Integer page) {
        return nativeMessageService.queryAppPage(userId, page);
    }

    /**
     * 站内消息操作 删除
     */
    @PostMapping("/app/message/delete")
    public Response delete(@RequestBody AppNativeMessageParam param) {
        return nativeMessageService.delete(param.getUserId(), param.getMessageIds());
    }

    /**
     * 站内消息操作 删除
     * 批量设置已读消息
     */
    @PostMapping("/app/message/modify")
    public Response modify(@RequestBody AppNativeMessageParam param) {
        return nativeMessageService.modify(param.getMessageIds());
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
