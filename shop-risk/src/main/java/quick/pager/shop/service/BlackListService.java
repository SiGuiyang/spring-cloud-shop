package quick.pager.shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.risk.BlackListDTO;
import quick.pager.shop.model.risk.BlackList;
import quick.pager.shop.mapper.BlackListMapper;
import quick.pager.shop.utils.DateUtils;

/**
 * @author siguiyang
 */
@Service
@Slf4j
public class BlackListService implements IService {

    @Autowired
    private BlackListMapper blackListMapper;

    @Override
    public Response doService(BaseDTO dto) {

        BlackListDTO blackListDTO = (BlackListDTO) dto;
        Response response;
        switch (blackListDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifyBlackList(blackListDTO);
                break;
            case Constants.Event.LIST:
                response = selectBlackLists(blackListDTO);
                break;
            case Constants.Event.DELETE:
                response = delBlackList(blackListDTO.getId());
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;

    }

    /**
     * 新增修改
     */
    private Response modifyBlackList(BlackListDTO blackListDTO) {
        BlackList blackList = new BlackList();
        BeanUtils.copyProperties(blackListDTO, blackList);
        if (Constants.Event.ADD.equals(blackListDTO.getEvent())) { // 新增
            blackList.setDeleteStatus(false);
            blackList.setCreateTime(DateUtils.dateTime());
            blackListMapper.insertSelective(blackList);
        } else {
            blackListMapper.updateByPrimaryKeySelective(blackList);
        }
        return new Response();
    }

    /**
     * 查询列表
     */
    private Response selectBlackLists(BlackListDTO blackListDTO) {
        BlackList blackList = new BlackList();
        BeanUtils.copyProperties(blackListDTO, blackList);
        QueryWrapper<BlackList> qw = new QueryWrapper<>();
        if (!StringUtils.isEmpty(blackListDTO.getPhone())) {
            qw.eq("phone", blackListDTO.getPhone());
        }
        return Response.toResponse(blackListMapper.selectPage(new Page<>(blackListDTO.getPage(), blackListDTO.getPageSize()), qw));
    }

    /**
     * 逻辑删除
     */
    private Response delBlackList(Long id) {
        BlackList blackList = new BlackList();
        blackList.setId(id);
        blackList.setDeleteStatus(Boolean.TRUE);
        blackListMapper.updateById(blackList);

        return new Response();
    }
}
