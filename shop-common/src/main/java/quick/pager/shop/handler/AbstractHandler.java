package quick.pager.shop.handler;

import quick.pager.shop.context.ShopSpringContext;

/**
 * 抽象的handler 处理基类
 *
 * @author siguiyang
 */
public abstract class AbstractHandler<T> implements IHandler<T> {

    /**
     * 根据requireType class对象类型返回具体的实现类
     *
     * @param requireType class对象
     */
    public static AbstractHandler getInstance(Class<? extends AbstractHandler> requireType) {
        return ShopSpringContext.getBean(requireType);
    }

}
