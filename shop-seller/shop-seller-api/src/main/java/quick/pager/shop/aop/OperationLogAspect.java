package quick.pager.shop.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import quick.pager.shop.user.response.Response;

/**
 * Service 层请求日志拦截<br />
 * 只处理入参与响应的参数
 *
 * @author siguiyang
 */
@Component
@Aspect
@Slf4j
public class OperationLogAspect {

    @Around("execution(* quick.pager.shop.order.service.*.doService(..))")
    public Response doOperation(ProceedingJoinPoint pjp) throws Throwable {

        log.info("========================================================================================");
        Object[] args = pjp.getArgs();
        Object target = pjp.getTarget();

        // service 层有入参
        if (args.length > 0) {
            log.info("== {}.doService INVOKER SERVICE PARAMS : {} ", target.getClass().getName(), JSON.toJSONString(args[0]));
        }

        Response result = (Response) pjp.proceed();

        log.info("= SERVICE RESPONSE : {}", JSON.toJSONString(result));
        log.info("========================================================================================");
        return result;
    }
}
