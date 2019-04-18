package quick.pager.shop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import quick.pager.shop.response.Response;

/**
 * Service 层请求日志拦截<br />
 * 只处理入参与响应的参数
 *
 * @author siguiyang
 */
@Component
@Aspect
@Slf4j
public class ResponseAspect {

    @Around("execution(* quick.pager.shop.controller.*.*.*(..))")
    public Response doOperation(ProceedingJoinPoint pjp) throws Throwable {

        log.info("========================================================================================");

        Response result = (Response) pjp.proceed();

        log.info("= SERVICE RESPONSE : {}", JSON.toJSONString(result));
        log.info("========================================================================================");
        return result;
    }
}
