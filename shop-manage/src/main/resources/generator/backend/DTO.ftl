package ${package}.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @author ${author}
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class ${className}DTO extends ManageDTO {
<#if columns??>
    <#list columns as column>
    <#if column.pkColumnType == "common">
    <#if column.columnComment != ''>
    /**
     * ${column.columnComment}
     */
    </#if>
    <#if column.hasDate>
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    </#if>
    private ${column.columnType} ${column.changeColumnName};
    </#if>
    </#list>
</#if>
}
