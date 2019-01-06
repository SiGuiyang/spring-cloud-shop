package quick.pager.shop.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.user.response.MessageResponse;

/**
 * 站内消息列表
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class MessageService implements IService<MessageResponse> {
    @Override
    public Response<MessageResponse> doService(DTO dto) {
        return null;
    }
}
