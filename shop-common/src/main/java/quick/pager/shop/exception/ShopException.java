package quick.pager.shop.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通用异常返回
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShopException extends RuntimeException {

    private static final long serialVersionUID = 7562952216658710834L;

    private int code;

    private String message;

    public ShopException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ShopException(String message, int code) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
