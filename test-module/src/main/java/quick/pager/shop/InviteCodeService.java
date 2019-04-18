package quick.pager.shop.service;

import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.service.IService;
import quick.pager.shop.dto.InviteCodeDTO;
import quick.pager.shop.model.InviteCode;
import quick.pager.shop.mapper.InviteCodeMapper;

/**
* @author siguiyang
*/
@Service
@Slf4j
public class InviteCodeService implements IService {

    @Autowired
    private InviteCodeMapper inviteCodeMapper;

    @Override
    public Response doService(BaseDTO dto) {

        InviteCodeDTO inviteCodeDTO = (InviteCodeDTO) dto;
        Response response;
        switch (inviteCodeDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifyInviteCode(inviteCodeDTO);
                break;
            case Constants.Event.LIST:
                response = selectInviteCodes(inviteCodeDTO);
                break;
            case Constants.Event.DELETE:
                response = delInviteCode(inviteCodeDTO.getId());
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;

    }

    /**
     * 新增修改
     */
    private Response modifyInviteCode(InviteCodeDTO inviteCodeDTO) {
        InviteCode inviteCode = new InviteCode();
        BeanUtils.copyProperties(inviteCodeDTO, inviteCode);
        if (Constants.Event.ADD.equals(inviteCodeDTO.getEvent())) { // 新增
            inviteCode.setDeleteStatus(false);
            inviteCode.setCreateTime(new Date());
            inviteCodeMapper.insertSelective(inviteCode);
        } else {
            inviteCodeMapper.updateByPrimaryKeySelective(inviteCode);
        }
        return new Response();
    }

    /**
     * 查询列表
     */
    private Response selectInviteCodes(InviteCodeDTO inviteCodeDTO) {
        InviteCode inviteCode = new InviteCode();
        BeanUtils.copyProperties(inviteCodeDTO, inviteCode);
        List<InviteCode> result = inviteCodeMapper.select(inviteCode);
        return Response.toResponse(result);
    }

    /**
     * 逻辑删除
     */
    private Response delInviteCode(Long id) {
        InviteCode inviteCode = new InviteCode();
        inviteCode.setId(id);
        inviteCode.setDeleteStatus(Boolean.TRUE);
        inviteCodeMapper.updateByPrimaryKeySelective(inviteCode);

        return new Response();
    }
}
