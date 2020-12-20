package quick.pager.shop.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.FeedbackService;
import quick.pager.shop.user.request.FeedbackRequest;
import quick.pager.shop.util.AuthUtils;

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
     * @param request 保存参数
     */
    @PostMapping("/app/feedback/create")
    public Response<Long> create(@RequestBody FeedbackRequest request) {
        // 获取当前登录人
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return feedbackService.create(principal.getId(), request);
    }
}
