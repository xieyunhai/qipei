package com.xieyunhai.aspect;

import com.xieyunhai.common.*;
import com.xieyunhai.exception.BaseException;
import com.xieyunhai.exception.NeedLoginException;
import com.xieyunhai.util.HttpResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by noobit on 17-7-5.
 */
@Aspect
@Component
public class LoginAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.xieyunhai.controller.portal.*.*UserId*(..))")
    public void handleLogin() {}

    @Before("handleLogin()")
    public void before(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        // todo 找到唯一的一个
        HttpSession session = (HttpSession) Arrays.stream(args)
                .filter(arg -> arg instanceof HttpSession)
                .findFirst()
                .orElse(null);
        if (ObjectUtils.isEmpty(session.getAttribute(Const.CURRENT_USER))) {
            throw new NeedLoginException(HttpResultEnum.NEED_LOGIN);
        }
    }

    @Around("handleLogin()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.error("Exception: {}", e);
            HttpResult httpResult;
            if (e instanceof NeedLoginException) {
                NeedLoginException needLoginException = (NeedLoginException) e;
                httpResult = HttpResultUtil.error(needLoginException.getCode(), needLoginException.getMessage());
            } else {
                httpResult = HttpResultUtil.error(HttpResultEnum.UN_KNOW);
            }
            return httpResult;
        }
        return result;
    }
}
