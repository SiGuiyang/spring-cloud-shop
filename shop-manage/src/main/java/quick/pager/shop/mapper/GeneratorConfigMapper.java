package quick.pager.shop.mapper;

import quick.pager.shop.model.GeneratorConfig;

public interface GeneratorConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(GeneratorConfig record);

    GeneratorConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GeneratorConfig record);

    GeneratorConfig selectGeneratorConfig();

}
