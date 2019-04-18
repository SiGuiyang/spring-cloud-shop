package ${package}.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author ${author}
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class ${className} extends Model {
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
