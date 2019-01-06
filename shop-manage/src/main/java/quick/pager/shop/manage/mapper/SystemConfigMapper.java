package quick.pager.shop.manage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.common.SystemConfig;

public interface SystemConfigMapper {

    int insertSelective(SystemConfig record);

    SystemConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemConfig record);

    /**
     * 配置列表
     * @param configName 配置项名称
     * @param module 所属模块
     */
    List<SystemConfig> selectSystemConfig(@Param("configName") String configName, @Param("module") String module);

}