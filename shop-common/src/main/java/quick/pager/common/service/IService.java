package quick.pager.common.service;


import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;

/**
 * 服务层基础接口<br />
 * 所有服务service 都应实现此接口
 *
 * @param <T>
 * @author siguiyang
 */
public interface IService<T> {

    Response<T> doService(DTO dto);
}
