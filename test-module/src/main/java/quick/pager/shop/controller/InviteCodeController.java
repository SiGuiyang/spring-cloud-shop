package quick.pager.shop.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.InviteCodeDTO;
import quick.pager.shop.service.InviteCodeService;
import quick.pager.shop.response.Response;


/**
* @author siguiyang
*/
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class InviteCodeController {

    @Autowired
    private InviteCodeService inviteCodeService;

    /**
     * 列表
     */
    @PostMapping(value = "/inviteCode/list")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response getInviteCodes(InviteCodeDTO dto){
        dto.setEvent(Constants.Event.LIST);
        return inviteCodeService.doService(dto);
    }
    /**
    * 新增
    */
    @PostMapping(value = "/inviteCode")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response addInviteCodes(InviteCodeDTO dto){
        dto.setEvent(Constants.Event.ADD);
        return inviteCodeService.doService(dto);
    }
    /**
    * 修改
    */
    @PutMapping(value = "/inviteCode")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response modifyInviteCodes(InviteCodeDTO dto){
        dto.setEvent(Constants.Event.MODIFY);
        return inviteCodeService.doService();
    }
    /**
    * 删除
    */
    @DeleteMapping(value = "/inviteCode/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response delInviteCodes(@PathVariable("id") Long id){
        InviteCodeDTO dto = new InviteCodeDTO();
        dto.setEvent(Constants.Event.DELETE);
        dto.setId(id);
        return inviteCodeService.doService(dto);
    }
}
