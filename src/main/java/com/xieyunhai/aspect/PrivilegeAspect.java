package com.xieyunhai.aspect;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.common.HttpResultEnum;
import com.xieyunhai.entity.User;
import com.xieyunhai.exception.PermissionDeniedException;
import com.xieyunhai.util.HttpResultUtil;
import com.xieyunhai.util.ParamsUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.CodeSigner;
import java.util.HashMap;
import java.util.Map;


/**
 * @author admin
 * @since 2017/7/6 9:35
 */
@Aspect
@Component
public class PrivilegeAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.xieyunhai.service.impl.*.*UserId*(..))")
    public void handlePrivilege() {}

    @Before("handlePrivilege()")
    public void before(JoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        // 得到方法的参数名
        String[] argNames = ParamsUtil.getFieldsName(className, methodName);

        Map<String, Object> params = ParamsUtil.getParams(argNames, args);

        if (params.containsKey("id") && params.containsKey("userId")){
            if (((Integer) params.get("id")).intValue() != ((Integer) params.get("userId"))) {
                throw new PermissionDeniedException(HttpResultEnum.PERMISSION_DENIED);
            }
        }

        if (params.containsKey("user") && params.containsKey("userId")) {
            if (((User) params.get("user")).getId().intValue() != ((Integer) params.get("userId"))) {
                throw new PermissionDeniedException(HttpResultEnum.PERMISSION_DENIED);
            }
        }

        if (params.containsKey("customer") && params.containsKey("userId")) {
            if (((User) params.get("customer")).getId().intValue() != ((Integer) params.get("userId"))) {
                throw new PermissionDeniedException(HttpResultEnum.PERMISSION_DENIED);
            }
        }
    }

    @Around("handlePrivilege()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.error("Exception: {}", e);
            HttpResult httpResult;
            if (e instanceof PermissionDeniedException) {
                PermissionDeniedException needLoginException = (PermissionDeniedException) e;
                httpResult = HttpResultUtil.error(needLoginException.getCode(), needLoginException.getMessage());
            } else {
                httpResult = HttpResultUtil.error(HttpResultEnum.UN_KNOW);
            }
            return httpResult;
        }
        return result;
    }


}
