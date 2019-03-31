package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.MessageResponse;
import quick.pager.shop.response.Response;

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
