package quick.pager.shop.configuration;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring 上下文
 *
 * @author siguiyang
 */
@Component
public class OSSContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        OSSContext.applicationContext = applicationContext;
    }


    /**
     * 获取Bean对象
     *
     * @param clazz class对象
     * @param <T>   泛型
     * @return Bean对象
     */
    public static <T> T getBean(final Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 获取Bean对象
     *
     * @param beanName spring beanName名称
     * @param clazz    class对象
     * @param <T>      泛型
     * @return Bean对象
     */
    public static <T> T getBean(final String beanName, final Class<T> clazz) {
        return getApplicationContext().getBean(beanName, clazz);
    }

    /**
     * 根据bean类型获取map对象
     *
     * @param clazz class对象
     * @param <T>   泛型
     * @return Bean对象
     */
    public static <T> Map<String, T> getBeanOfType(Class<T> clazz) {
        return getApplicationContext().getBeansOfType(clazz);
    }

    /**
     * 根据bean类型获取list对象
     *
     * @param clazz class对象
     * @param <T>   泛型
     * @return Bean对象
     */
    public static <T> List<T> getBeans(Class<T> clazz) {
        return Lists.newArrayList(getBeanOfType(clazz).values());
    }


    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
