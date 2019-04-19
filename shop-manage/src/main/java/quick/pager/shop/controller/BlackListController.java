package quick.pager.shop.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.BlackListDTO;
import quick.pager.shop.service.risk.BlackListService;
import quick.pager.shop.response.Response;


/**
* @author siguiyang
*/
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    /**
     * 列表
     */
    @PostMapping(value = "/blackList/list")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response getBlackLists(BlackListDTO dto){
        dto.setEvent(Constants.Event.LIST);
        return blackListService.doService(dto);
    }
    /**
    * 新增
    */
    @PostMapping(value = "/blackList")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response addBlackLists(BlackListDTO dto){
        dto.setEvent(Constants.Event.ADD);
        return blackListService.doService(dto);
    }
    /**
    * 修改
    */
    @PutMapping(value = "/blackList")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response modifyBlackLists(BlackListDTO dto){
        dto.setEvent(Constants.Event.MODIFY);
        return blackListService.doService(dto);
    }
    /**
    * 删除
    */
    @DeleteMapping(value = "/blackList/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Response delBlackLists(@PathVariable("id") Long id){
        BlackListDTO dto = new BlackListDTO();
        dto.setEvent(Constants.Event.DELETE);
        dto.setId(id);
        return blackListService.doService(dto);
    }
}
