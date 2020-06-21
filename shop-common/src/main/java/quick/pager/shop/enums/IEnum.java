package quick.pager.shop.enums;

/**
 * 顶级枚举接口
 *
 * @param <T> 泛型类型
 * @author siguiyang
 * @version 3.0.0
 * @date 2020年06月21日
 */
public interface IEnum<T> {

    /**
     * 返回枚举类型
     *
     * @return T
     */
    T getCode();

    /**
     * 枚举对应的说明
     *
     * @return 说明
     */
    String getDesc();
}
