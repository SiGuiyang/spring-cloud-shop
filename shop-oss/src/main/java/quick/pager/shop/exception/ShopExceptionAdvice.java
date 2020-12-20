package quick.pager.shop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;

/**
 * 统一异常处理机制
 *
 * @author siguiyang
 */
@RestControllerAdvice
@Slf4j
public class ShopExceptionAdvice {

    @ExceptionHandler
    public Object doException(Exception e) {
        log.error("统一异常处理机制，触发异常 msg = {}", e);
        if (e instanceof OSSException) {
            OSSException exception = (OSSException) e;
            return Response.toError(exception.getCode(), exception.getMessage());
        }
        return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
    }
}
