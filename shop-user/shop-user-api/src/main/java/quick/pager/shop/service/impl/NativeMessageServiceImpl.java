package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.request.NativeMessagePageRequest;
import quick.pager.shop.user.response.NativeMessageResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.mapper.NativeMessageMapper;
import quick.pager.shop.model.NativeMessage;
import quick.pager.shop.service.NativeMessageService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 站内信实现
 *
 * @author siguiyang
 */
@Service
public class NativeMessageServiceImpl extends ServiceImpl<NativeMessageMapper, NativeMessage> implements NativeMessageService {

    @Override
    public Response<List<NativeMessageResponse>> queryPage(final NativeMessagePageRequest request) {
        return null;
    }

    @Override
    public Response<List<NativeMessageResponse>> queryAppPage(final Long userId, final Integer page) {

        LambdaQueryWrapper<NativeMessage> wrapper = new LambdaQueryWrapper<NativeMessage>()
                .eq(NativeMessage::getDeleteStatus, Boolean.FALSE)
                .eq(NativeMessage::getUserId, userId);
        Response<List<NativeMessage>> response = this.toPage(page, IConsts.TEN, wrapper);

        return Response.toResponse(response.getData().stream().map(this::convert).collect(Collectors.toList()), response.getTotal());
    }

    @Override
    public Response<NativeMessageResponse> info(final Long id) {
        NativeMessage message = this.baseMapper.selectById(id);
        if (Objects.isNull(message) || message.getDeleteStatus()) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "消息不存在！");
        }

        if (IConsts.ZERO.equals(message.getStatus())) {
            NativeMessage updateNativeMessage = new NativeMessage();
            updateNativeMessage.setId(id);
            updateNativeMessage.setStatus(IConsts.ONE);
            updateNativeMessage.setUpdateTime(DateUtils.dateTime());
            this.baseMapper.updateById(updateNativeMessage);
        }
        return Response.toResponse(this.convert(message));
    }

    @Override
    public Response<Integer> count(final Long userId) {

        LambdaQueryWrapper<NativeMessage> wrapper = new LambdaQueryWrapper<NativeMessage>()
                .eq(NativeMessage::getDeleteStatus, Boolean.FALSE)
                .eq(NativeMessage::getUserId, userId)
                .eq(NativeMessage::getStatus, IConsts.ZERO);

        Integer count = this.baseMapper.selectCount(wrapper);
        return Response.toResponse(count);
    }

    @Override
    public Response delete(final Long userId, final List<Long> messageIds) {
        NativeMessage nativeMessage = new NativeMessage();
        nativeMessage.setDeleteStatus(Boolean.TRUE);
        nativeMessage.setStatus(IConsts.ONE);
        this.baseMapper.update(nativeMessage, new LambdaQueryWrapper<NativeMessage>()
                .eq(NativeMessage::getDeleteStatus, Boolean.FALSE)
                .eq(NativeMessage::getUserId, userId)
                .eq(NativeMessage::getStatus, IConsts.ZERO)
                .in(NativeMessage::getId, messageIds));
        return Response.toResponse();
    }

    @Override
    public Response modify(List<Long> messageIds) {

        NativeMessage nativeMessage = new NativeMessage();
        nativeMessage.setDeleteStatus(Boolean.FALSE);
        nativeMessage.setStatus(IConsts.ONE);
        this.baseMapper.update(nativeMessage, new LambdaQueryWrapper<NativeMessage>()
                .eq(NativeMessage::getDeleteStatus, Boolean.FALSE)
                .in(NativeMessage::getId, messageIds));
        return Response.toResponse();
    }

    private NativeMessageResponse convert(final NativeMessage nativeMessage) {
        return BeanCopier.copy(nativeMessage, new NativeMessageResponse());
    }
}
