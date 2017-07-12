package com.xieyunhai.aspect;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.common.HttpResultEnum;
import com.xieyunhai.util.HttpResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author admin
 * @since 2017/7/4 10:39
 */
@Aspect
@Component
public class ExceptionAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.xieyunhai.service.impl.*.*(..))")
    public void handleException() {}

    /* 执行顺序: around之前 >> before >> around之后 >> after >> afterReturn */

    @Before("handleException()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.warn(className + " 的 " + methodName + " 执行了!");
        Object[] args = joinPoint.getArgs();
        String log = Arrays.stream(args)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        logger.warn("入参为: {}", log);
    }

    @Around(value = "handleException()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.warn("前置增强...");
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            HttpResult httpResult;
            if (e instanceof NestedRuntimeException) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                logger.error("NestedRuntimeException: {}", e);
                httpResult = HttpResultUtil.error(HttpResultEnum.ERROR_DATABASE);
            } else {
                logger.error("Exception: {}", e);
                httpResult = HttpResultUtil.error(HttpResultEnum.UN_KNOW);
            }
            return httpResult;
        }
        return result;
    }
}
