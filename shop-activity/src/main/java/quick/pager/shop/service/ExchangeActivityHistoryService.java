package quick.pager.shop.service;

import com.github.pagehelper.PageHelper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.ExchangeActivityDTO;
import quick.pager.shop.mapper.ExchangeActivityMembersMapper;
import quick.pager.shop.response.ExchangeMemberResponse;
import quick.pager.shop.response.Response;

@Service
public class ExchangeActivityHistoryService implements IService {

    @Autowired
    private ExchangeActivityMembersMapper exchangeActivityMembersMapper;


    @Override
    public Response doService(BaseDTO dto) {

        ExchangeActivityDTO exchangeActivityDTO = (ExchangeActivityDTO) dto;

        PageHelper.startPage(exchangeActivityDTO.getPage(), exchangeActivityDTO.getPageSize());

        List<ExchangeMemberResponse> mapList = exchangeActivityMembersMapper.select(exchangeActivityDTO.getActivityId(),
                exchangeActivityDTO.getPhone(), exchangeActivityDTO.getRuleId());

        return Response.toResponse(mapList);
    }
}
