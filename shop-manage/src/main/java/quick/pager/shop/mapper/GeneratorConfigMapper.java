package quick.pager.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import quick.pager.shop.model.GeneratorConfig;
@Mapper
public interface GeneratorConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(GeneratorConfig record);

    GeneratorConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GeneratorConfig record);

    GeneratorConfig selectGeneratorConfig();

}
