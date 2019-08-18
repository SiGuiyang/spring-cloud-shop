package quick.pager.shop.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShopValidException extends RuntimeException {

    private int code;

    public ShopValidException(int code) {
        this.code = code;
    }

    public ShopValidException(int code, String message) {
        super(message);
        this.code = code;
    }
}
