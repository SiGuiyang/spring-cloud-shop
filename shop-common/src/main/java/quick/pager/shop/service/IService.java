package quick.pager.shop.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import quick.pager.shop.user.response.Response;

/**
 * 服务层基础接口<br />
 * 所有服务service 都应实现此接口
 *
 * @param <T>
 * @author siguiyang
 * @version 3.0
 */
public interface IService<T> {

    /**
     * 获取对应 entity 的 BaseMapper
     *
     * @return BaseMapper
     */
    BaseMapper<T> getBaseMapper();

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    T getById(Serializable id);

    /**
     * 根据 Wrapper，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    T getOne(Wrapper<T> queryWrapper);

    /**
     * 根据 Wrapper 条件，查询总记录数
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    int count(Wrapper<T> queryWrapper);

    /**
     * 查询列表
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    List<T> list(Wrapper<T> queryWrapper);

    /**
     * 翻页查询
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);

    /**
     * 分页处理service
     *
     * @param page     页码
     * @param pageSize 一页显示的大小
     */
    default Response<List<T>> toPage(int page, int pageSize, Wrapper<T> wrapper) {
        int total = this.count(wrapper);
        List<T> result = Collections.emptyList();
        if (0 < total) {
            result = this.page(new Page<>(page, pageSize, false), wrapper).getRecords();
        }
        return Response.toResponse(result, total);
    }
}
