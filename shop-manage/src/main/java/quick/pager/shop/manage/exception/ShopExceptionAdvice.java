package quick.pager.shop.manage.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;

/**
 * 统一异常处理机制
 *
 * @author siguiyang
 */
@RestControllerAdvice
public class ShopExceptionAdvice {

    @ExceptionHandler
    public Object doException(Exception e) {
        if (e instanceof ShopException) {
            ShopException exception = (ShopException) e;
            return new Response<>(exception.getCode(), exception.getMessage());
        }
        return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
    }
}
