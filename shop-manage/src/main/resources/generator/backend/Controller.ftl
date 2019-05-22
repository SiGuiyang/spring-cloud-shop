package ${package}.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ${package}.constants.Constants;
import ${package}.dto.${className}DTO;
import ${package}.service.${className}Service;
import quick.pager.shop.response.Response;


/**
* @author ${author}
*/
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class ${className}Controller {

    @Autowired
    private ${className}Service ${changeClassName}Service;

    /**
     * 列表
     */
    @PostMapping(value = "/${changeClassName}/list")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response get${className}s(${className}DTO dto){
        dto.setEvent(Constants.Event.LIST);
        return ${changeClassName}Service.doService(dto);
    }
    /**
    * 新增
    */
    @PostMapping(value = "/${changeClassName}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response add${className}s(${className}DTO dto){
        dto.setEvent(Constants.Event.ADD);
        return ${changeClassName}Service.doService(dto);
    }
    /**
    * 修改
    */
    @PutMapping(value = "/${changeClassName}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response modify${className}s(${className}DTO dto){
        dto.setEvent(Constants.Event.MODIFY);
        return ${changeClassName}Service.doService(dto);
    }
    /**
    * 删除
    */
    @DeleteMapping(value = "/${changeClassName}/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Response del${className}s(@PathVariable("id") Long id){
        ${className}DTO dto = new ${className}DTO();
        dto.setEvent(Constants.Event.DELETE);
        dto.setId(id);
        return ${changeClassName}Service.doService(dto);
    }
}
