package quick.pager.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.model.activity.ExchangeActivity;

/**
 * @author siguiyang
 */
@Mapper
public interface ExchangeActivityMapper {

    int insertSelective(ExchangeActivity record);

    ExchangeActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExchangeActivity record);

    /**
     * 根据activityName 查询活动
     */
    List<ExchangeActivity> select(@Param("activityName") String activityName);
}
