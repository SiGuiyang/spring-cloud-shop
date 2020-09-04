package quick.pager.shop.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;

/**
 * 统一异常处理
 *
 * @author siguiyang
 */
@RestControllerAdvice
public class ShopAdvice {

    @ExceptionHandler
    public Response<String> doException(Exception e) {

        if (e instanceof ShopException) {
            return new Response<>(((ShopException) e).getCode(), e.getMessage());
        }

        return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.TELNET_EXCEPTION);
    }
}
