package quick.pager.shop.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;

/**
 * 站内消息
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class NativeMessageController {


    /**
     * 站内消息列表
     */
    @PostMapping("/message/{userId}")
    public Response message(@PathVariable("userId") Long userId) {
        return null;
    }


    /**
     * 站内消息操作 删除 已读
     */
    @PostMapping("/message/modify")
    public Response modifyMessage() {
        return null;
    }
}
