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

    public ShopException(String message) {
        super(message);
    }
}
