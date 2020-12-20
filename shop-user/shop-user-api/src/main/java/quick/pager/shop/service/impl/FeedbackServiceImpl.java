package quick.pager.shop.service.impl;

import org.springframework.stereotype.Service;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.mapper.FeedbackMapper;
import quick.pager.shop.model.Feedback;
import quick.pager.shop.user.request.FeedbackRequest;
import quick.pager.shop.service.FeedbackService;
import quick.pager.shop.utils.Assert;
import quick.pager.shop.utils.DateUtils;

/**
 * 意见反馈
 *
 * @author siguiyang
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {


    @Override
    public Response<Long> create(final Long userId, final FeedbackRequest param) {

        Feedback feedback = new Feedback();
        feedback.setUserId(userId);
        feedback.setContent(param.getContent());
        feedback.setImages(param.getImages());
        feedback.setDeleteStatus(Boolean.FALSE);
        feedback.setCreateTime(DateUtils.dateTime());
        feedback.setUpdateTime(DateUtils.dateTime());
        Assert.isTrue(this.baseMapper.insert(feedback) > 0, () -> "意见反馈提交失败");
        return Response.toResponse(feedback.getId());
    }
}
