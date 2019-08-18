package quick.pager.shop.handler;

/**
 * 业务处理上下文
 *
 * @author siguiyang
 */
public interface HandlerContext {

    /**
     * 添加业务执行器
     *
     * @param handler 业务处理对象
     */
    void addHandler(IHandler handler);

    /**
     * 添加业务执行器
     *
     * @param handlerName 业务处理对象名称
     * @param handler     业务处理对象
     */
    void addHandler(String handlerName, IHandler handler);

    /**
     * 创建业务执行器
     *
     * @param handler 业务处理对象
     */
    void createHandler(IHandler handler);
}
