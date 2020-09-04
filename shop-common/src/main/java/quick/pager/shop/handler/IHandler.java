package quick.pager.shop.handler;

import quick.pager.shop.user.response.Response;

/**
 * 策略模式顶级接口
 *
 * @author siguiyang
 */
public interface IHandler<T> {

    /**
     * 调用方法
     *
     * @param obj 请求入参
     * @return 数据结果返回
     */
    Response<T> doHandler(Object obj);

}
