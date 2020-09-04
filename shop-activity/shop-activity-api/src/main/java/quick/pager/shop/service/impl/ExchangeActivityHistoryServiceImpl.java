package quick.pager.shop.service.impl;

import org.springframework.stereotype.Service;
import quick.pager.shop.model.ExchangeActivityMember;
import quick.pager.shop.service.ExchangeActivityHistoryService;
import quick.pager.shop.mapper.ExchangeActivityMembersMapper;

@Service
public class ExchangeActivityHistoryServiceImpl extends ServiceImpl<ExchangeActivityMembersMapper, ExchangeActivityMember> implements ExchangeActivityHistoryService {

//    @Autowired
//    private ExchangeActivityMembersMapper exchangeActivityMembersMapper;
//
//
//    @Override
//    public Response doService(BaseDTO dto) {
//
////        ExchangeActivityDTO exchangeActivityDTO = (ExchangeActivityDTO) param;
////
////        IPage<ExchangeMemberDTO> page = new Page<>(exchangeActivityDTO.getPage(), exchangeActivityDTO.getPageSize());
////
////        QueryWrapper<ExchangeMemberDTO> qw = new QueryWrapper<>();
////
////        qw.eq("am.activity_id", exchangeActivityDTO.getActivityId());
////        if (!StringUtils.isEmpty(exchangeActivityDTO.getPhone())) {
////            qw.eq("am.phone", exchangeActivityDTO.getPhone());
////        }
////        if (null != exchangeActivityDTO.getRuleId()) {
////            qw.eq("ar.id", exchangeActivityDTO.getRuleId());
////        }
////        qw.orderByDesc("am.id");
////        return Response.toResponse(exchangeActivityMembersMapper.select(page, qw));
//        return null;
//    }
}
