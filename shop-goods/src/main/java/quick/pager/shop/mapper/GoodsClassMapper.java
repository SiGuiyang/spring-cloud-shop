package quick.pager.shop.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.model.goods.GoodsClass;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Mapper
public interface GoodsClassMapper extends BaseMapper<GoodsClass> {

    /**
     * 分页查询分类
     */
    @Select("select t1.id,t1.parent_id as parentId,t1.class_name as className,t1.icon," +
            "t1.create_user as createUser,t1.update_user as updateUser,t1.create_time as createTime," +
            "t1.update_time as updateTime,t1.delete_status as deleteStatus,t2.class_name as parentClassName " +
            "from t_goods_class t1 left join t_goods_class t2 on t1.parent_id = t2.id")
    IPage<ClassificationDTO> selectGoodsClassList(IPage<ClassificationDTO> page, @Param(Constants.WRAPPER) Wrapper<ClassificationDTO> wrapper);

    /**
     * 根据分类主键查询关联的t_banner 主键
     *
     * @param classId 分类主键
     */
    @Select("select goods_banner_id from t_goods_class_banner where goods_class_id = #{classId}")
    List<Long> selectClassBannerIds(@Param("classId") Long classId);
}
