package ${package}.mapper;

import java.util.List;

import ${package}.model.${className};

/**
* @author ${author}
*/
public interface ${className}Mapper {

    int insertSelective(${className} record);

    ${className} selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(${className} record);
    /**
     * 表格查询
     */
    List<${className}> select(${className} record);
}
