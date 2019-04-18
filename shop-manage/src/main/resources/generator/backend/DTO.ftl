package ${package}.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;


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
    private ${column.columnType} ${column.changeColumnName};
    </#if>
    </#list>
</#if>
}
