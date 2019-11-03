package quick.pager.shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.dto.ExchangeMemberDTO;
import quick.pager.shop.mapper.ExchangeActivityMembersMapper;
import quick.pager.shop.response.Response;

@Service
public class ExchangeActivityHistoryService implements IService {

    @Autowired
    private ExchangeActivityMembersMapper exchangeActivityMembersMapper;


    @Override
    public Response doService(BaseDTO dto) {

        ExchangeActivityDTO exchangeActivityDTO = (ExchangeActivityDTO) dto;

        IPage<ExchangeMemberDTO> page = new Page<>(exchangeActivityDTO.getPage(), exchangeActivityDTO.getPageSize());

        QueryWrapper<ExchangeMemberDTO> qw = new QueryWrapper<>();

        qw.eq("am.activity_id", exchangeActivityDTO.getActivityId());
        if (!StringUtils.isEmpty(exchangeActivityDTO.getPhone())) {
            qw.eq("am.phone", exchangeActivityDTO.getPhone());
        }
        if (null != exchangeActivityDTO.getRuleId()) {
            qw.eq("ar.id", exchangeActivityDTO.getRuleId());
        }
        qw.orderByDesc("am.id");
        return Response.toResponse(exchangeActivityMembersMapper.select(page, qw));
    }
}
