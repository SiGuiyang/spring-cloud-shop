package quick.pager.shop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;

/**
 * 统一异常处理
 *
 * @author siguiyang
 */
@RestControllerAdvice
@Slf4j
public class ShopAdvice {

    @ExceptionHandler(Exception.class)
    public Response<String> doException(Exception e) {

        log.error("统一异常处理机制，触发异常 msg = {}", e);
        String message = null;
        if (e instanceof ShopException) {
            ShopException exception = (ShopException) e;
            message = exception.getMessage();
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            message = "不支持GET/POST方法";
        } else if (e instanceof NoHandlerFoundException) {
            message = "请求接口不存在";
        }

        return Response.toError(ResponseStatus.Code.FAIL_CODE, message);
    }
}
