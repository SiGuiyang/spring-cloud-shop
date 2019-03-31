package quick.pager.shop.service;


import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;

/**
 * 服务层基础接口<br />
 * 所有服务service 都应实现此接口
 *
 * @param <T>
 * @author siguiyang
 */
public interface IService<T> {

    Response<T> doService(BaseDTO dto);
}
