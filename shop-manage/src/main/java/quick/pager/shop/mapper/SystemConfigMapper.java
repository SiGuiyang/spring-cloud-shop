package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.SystemConfig;

@Mapper
public interface SystemConfigMapper extends BaseMapper<SystemConfig> {

    /**
     * 配置列表
     *
     * @param configName 配置项名称
     * @param module     所属模块
     */
    List<SystemConfig> selectSystemConfig(@Param("configName") String configName, @Param("module") String module);

}
