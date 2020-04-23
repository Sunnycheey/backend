package dblab.bit.backend.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: backend
 * @description: Central aop class for logging
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    // 第一个*表示返回类型，两个点表示递归下去的子包，第二个*忘了，第三个*表示方法，(..)表示参数
    @Pointcut("execution(* dblab.bit.backend.controller..*.*(..))")
    private void controllerPointCut() {

    }

    @Before("controllerPointCut()")
    public void logBeforeMethod(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("Request for url: {}, http method: {}, corresponding class is {}",
                request.getRequestURL().toString(), request.getMethod(), joinPoint.getSignature().getDeclaringType());
    }

    @AfterReturning(returning = "ret", pointcut = "controllerPointCut()")
    public void logAfterReturn(Object ret) {
        logger.info("Process successfully");
    }
}
