package quick.pager.shop.auth.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShopException extends RuntimeException {
    private static final long serialVersionUID = -2013396565671482319L;

    private int code;

    public ShopException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ShopException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ShopException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public ShopException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
