package ${package}.service;

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
import ${package}.dto.${className}DTO;
import ${package}.model.${className};
import ${package}.mapper.${className}Mapper;

/**
* @author ${author}
*/
@Service
@Slf4j
public class ${className}Service implements IService {

    @Autowired
    private ${className}Mapper ${changeClassName}Mapper;

    @Override
    public Response doService(BaseDTO dto) {

        ${className}DTO ${changeClassName}DTO = (${className}DTO) dto;
        Response response;
        switch (${changeClassName}DTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modify${className}(${changeClassName}DTO);
                break;
            case Constants.Event.LIST:
                response = select${className}s(${changeClassName}DTO);
                break;
            case Constants.Event.DELETE:
                response = del${className}(${changeClassName}DTO.getId());
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;

    }

    /**
     * 新增修改
     */
    private Response modify${className}(${className}DTO ${changeClassName}DTO) {
        ${className} ${changeClassName} = new ${className}();
        BeanUtils.copyProperties(${changeClassName}DTO, ${changeClassName});
        if (Constants.Event.ADD.equals(${changeClassName}DTO.getEvent())) { // 新增
            ${changeClassName}.setDeleteStatus(false);
            ${changeClassName}.setCreateTime(new Date());
            ${changeClassName}Mapper.insertSelective(${changeClassName});
        } else {
            ${changeClassName}Mapper.updateByPrimaryKeySelective(${changeClassName});
        }
        return new Response();
    }

    /**
     * 查询列表
     */
    private Response select${className}s(${className}DTO ${changeClassName}DTO) {
        ${className} ${changeClassName} = new ${className}();
        BeanUtils.copyProperties(${changeClassName}DTO, ${changeClassName});
        List<${className}> result = ${changeClassName}Mapper.select(${changeClassName});
        return Response.toResponse(result);
    }

    /**
     * 逻辑删除
     */
    private Response del${className}(Long id) {
        ${className} ${changeClassName} = new ${className}();
        ${changeClassName}.setId(id);
        ${changeClassName}.setDeleteStatus(Boolean.TRUE);
        ${changeClassName}Mapper.updateByPrimaryKeySelective(${changeClassName});

        return new Response();
    }
}
