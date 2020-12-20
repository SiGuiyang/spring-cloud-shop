package quick.pager.shop.service;

import quick.pager.shop.user.response.Response;
import quick.pager.shop.model.Feedback;
import quick.pager.shop.user.request.FeedbackRequest;

/**
 * 意见反馈
 *
 * @author siguiyang
 */
public interface FeedbackService extends IService<Feedback> {

    /**
     * 提交意见反馈
     *
     * @param userId 用户主键
     * @param param  保存内容
     */
    Response<Long> create(final Long userId, final FeedbackRequest param);
}
