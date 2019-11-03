package quick.pager.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Collections;
import java.util.List;
import quick.pager.shop.response.Response;

/**
 * 统一 分页service 服务
 *
 * @param <T>
 */
public interface IPageService<T> extends com.baomidou.mybatisplus.extension.service.IService<T> {

    /**
     * 分页处理service
     *
     * @param page     页码
     * @param pageSize 一页显示的大小
     */
    default Response<List<T>> toPage(int page, int pageSize, Wrapper<T> wrapper) {
        int count = this.count(wrapper);
        List<T> result = Collections.emptyList();
        if (0 < count) {
            result = this.page(new Page<>(page, pageSize, false), wrapper).getRecords();
        }
        return Response.toResponse(result, count);
    }
}
