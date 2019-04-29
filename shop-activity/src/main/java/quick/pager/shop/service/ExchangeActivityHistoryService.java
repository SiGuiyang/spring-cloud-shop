package quick.pager.shop.service;

import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.ExchangeActivityDTO;
import quick.pager.shop.response.Response;

@Service
public class ExchangeActivityHistoryService implements IService {
    @Override
    public Response doService(BaseDTO dto) {

        ExchangeActivityDTO exchangeActivityDTO = (ExchangeActivityDTO) dto;

        return null;
    }
}
