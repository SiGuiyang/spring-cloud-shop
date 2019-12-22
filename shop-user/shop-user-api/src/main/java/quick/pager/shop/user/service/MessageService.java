package quick.pager.shop.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.user.response.MessageResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;

/**
 * 站内消息列表
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class MessageService implements IService<MessageResponse> {
    @Override
    public Response<MessageResponse> doService(BaseDTO dto) {
        return null;
    }
}
