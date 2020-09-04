package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.user.request.NativeMessagePageRequest;
import quick.pager.shop.user.response.NativeMessageResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.model.NativeMessage;

/**
 * 站内信
 *
 * @author siguiyang
 */
public interface NativeMessageService extends IService<NativeMessage> {

    /**
     * 站内信分页
     *
     * @param request 请求参数
     * @return 响应结果
     */
    Response<List<NativeMessageResponse>> queryPage(final NativeMessagePageRequest request);

    /**
     * 站内信分页
     *
     * @param userId 用户主键
     * @param page   页码
     * @return 响应结果
     */
    Response<List<NativeMessageResponse>> queryAppPage(final Long userId, final Integer page);

    /**
     * 站内信详情
     *
     * @param id 站内行主键
     * @return 详情
     */
    Response<NativeMessageResponse> info(final Long id);

    /**
     * 未读消息个数
     *
     * @param userId 当前用户主键
     * @return 消息个数
     */
    Response<Integer> count(final Long userId);

    /**
     * 批量删除站内信
     *
     * @param userId     当前用户主键
     * @param messageIds 站内信主键集
     */
    Response delete(final Long userId, final List<Long> messageIds);

    /**
     * 批量设置站内信已读
     *
     * @param messageIds 站内信主键集
     */
    Response modify(final List<Long> messageIds);

}
