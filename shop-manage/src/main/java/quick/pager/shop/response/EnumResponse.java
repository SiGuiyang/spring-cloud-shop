package quick.pager.shop.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 通用枚举类响应
 *
 * @author siguiyang
 */
@Data
public class EnumResponse implements Serializable {

    private static final long serialVersionUID = -1280398705355998555L;

    /**
     * 枚举类型 --> 整型
     */
    private Integer type;
    /**
     * 枚举类型 --> 字符串
     */
    private String key;
    /**
     * 枚举值
     */
    private String value;
    /**
     * 枚举描述
     */
    private String description;

    public EnumResponse(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public EnumResponse(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public EnumResponse(Integer type, String value, String description) {
        this(type, value);
        this.value = value;
        this.description = description;
    }

    public EnumResponse(String key, String value, String description) {
        this(key, value);
        this.description = description;
    }
}
