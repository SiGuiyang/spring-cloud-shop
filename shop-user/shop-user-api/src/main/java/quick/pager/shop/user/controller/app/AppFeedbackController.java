package quick.pager.shop.user.controller.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.param.FeedbackParam;

/**
 * app意见反馈
 *
 * @author siguiyang
 * @version 3.0.0
 * @since 3.0.0
 */
@RestController
@RequestMapping(ConstantsClient.USER)
public class AppFeedbackController {

    /**
     * 用户反馈列表
     *
     * @param userId 用户主键
     * @return
     */
    @GetMapping("/app/feedback/{userId}/{page}")
    public Response list(@PathVariable("userId") Long userId, @PathVariable("page") Integer page) {

        return null;
    }

    /**
     * 用户提交意见反馈
     *
     * @param userId 用户主键
     * @return
     */
    @PostMapping("/app/feedback/{userId}/create")
    public Response create(@PathVariable("userId") Long userId, @RequestBody FeedbackParam param) {

        return null;
    }
}
