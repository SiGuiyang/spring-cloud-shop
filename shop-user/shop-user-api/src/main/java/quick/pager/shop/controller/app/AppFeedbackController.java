package quick.pager.shop.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.FeedbackService;
import quick.pager.shop.param.FeedbackParam;

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

    @Autowired
    private FeedbackService feedbackService;

    /**
     * 用户提交意见反馈
     *
     * @param userId 用户主键
     * @param param  保存参数
     */
    @PostMapping("/app/feedback/{userId}/create")
    public Response<Long> create(@PathVariable("userId") Long userId, @RequestBody FeedbackParam param) {

        return feedbackService.create(userId, param);
    }
}
