package quick.pager.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.BlackListMapper;
import quick.pager.shop.model.BlackList;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.BlackListService;

@Service
@Slf4j
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    private BlackListMapper blackListMapper;


    @Override
    public Response create() {
//        BlackList blackList = new BlackList();
//        blackList.setId(id);
//        blackList.setDeleteStatus(Boolean.TRUE);
//        blackListMapper.updateById(blackList);
//
//        return new Response();
//
        return null;
    }

    @Override
    public Response modify() {
        BlackList blackList = new BlackList();
//        BeanUtils.copyProperties(blackListDTO, blackList);
//        if (Constants.Event.ADD.equals(blackListDTO.getEvent())) { // 新增
//            blackList.setDeleteStatus(false);
//            blackList.setCreateTime(DateUtils.dateTime());
//            blackListMapper.insert(blackList);
//        } else {
//            blackListMapper.updateById(blackList);
//        }
        return new Response();
    }

    @Override
    public Response queryList() {
//        BlackList blackList = new BlackList();
//        BeanUtils.copyProperties(blackListDTO, blackList);
//        QueryWrapper<BlackList> qw = new QueryWrapper<>();
//        if (!StringUtils.isEmpty(blackListDTO.getPhone())) {
//            qw.eq("phone", blackListDTO.getPhone());
//        }
//        return Response.toResponse(blackListMapper.selectPage(new Page<>(blackListDTO.getPage(), blackListDTO.getPageSize()), qw));
        return null;
    }

    @Override
    public Response queryPage() {
        return null;
    }

}
