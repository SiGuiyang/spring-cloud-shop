package quick.pager.shop.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定oss异常
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OSSException extends RuntimeException {
    private static final long serialVersionUID = -2013396565671482319L;

    private int code;

    public OSSException(int code, String message) {
        super(message);
        this.code = code;
    }

    public OSSException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public OSSException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public OSSException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
