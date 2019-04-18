<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package}.mapper.${className}Mapper">
    <resultMap id="BaseResultMap" type="${package}.model.${className}">
<#if columns ??>
<#list columns as column>
    <#if column.pkColumnType == 'common'>
    <result column="${column.columnName}" jdbcType="${column.dataType}" property="${column.changeColumnName}"/>
    <#else>
    <id column="${column.columnName}" jdbcType="${column.dataType}" property="${column.changeColumnName}"/>
    </#if>
</#list>
</#if>
    </resultMap>
    <sql id="Base_Column_List">
<#if columns ??>
    <#list columns as column>
        ${column.columnName}<#if column_has_next>,</#if>
    </#list>
</#if>
    </sql>
    <select id="selectByPrimaryKey" parameterType="java.lang.Long" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        where id = ${id}
    </select>

    <insert id="insertSelective" parameterType="${package}.model.${className}">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">

<#if columns ??>
    <#list columns as column>
        <if test="${column.changeColumnName} != null">
            ${column.columnName},
        </if>
    </#list>
</#if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
<#if columns ??>
    <#list columns as column>
        <if test="${column.changeColumnName} != null">
            ${column.columnJdbcType},
        </if>
    </#list>
</#if>
        </trim>
    </insert>

    <update id="updateByPrimaryKeySelective" parameterType="${package}.model.${className}">
        update ${tableName}
        <set>
<#if columns ??>
    <#list columns as column>
        <#if column.pkColumnType == 'common'>
            <if test="${column.changeColumnName} != null">
                ${column.columnName} = ${column.columnJdbcType},
            </if>
         </#if>
    </#list>
</#if>
        </set>
        where id = ${id}
    </update>

    <select id="select" parameterType="${package}.model.${className}" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        <where>
<#if columns ??>
    <#list columns as column>
        <#if column_index = 0>
            <if test="${column.changeColumnName} != null">
                ${column.columnName} = ${column.columnJdbcType},
            </if>
        <#else>
            <if test="${column.changeColumnName} != null">
                and ${column.columnName} = ${column.columnJdbcType},
            </if>
        </#if>
    </#list>
</#if>
        </where>
    </select>

</mapper>
