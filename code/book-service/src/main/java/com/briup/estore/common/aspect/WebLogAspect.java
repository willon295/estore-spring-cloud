package com.briup.estore.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;


/**
 * 全局通用 Controller 日志收集 切面
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
@Component
@Aspect
@Slf4j
public class WebLogAspect {


    /**
     * 指定切点， 所有controller的所有方法
     */
    @Pointcut("execution(* com.briup.estore.controller..*.*(..))")
    public void pointcut() {
    }


    /**
     * 请求之前， 记录客户端的信息， 请求的信息，处理的方法
     *
     * @param joinPoint 被织入的切点
     */
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        //获取请求
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();


        //记录请求日志
        log.info("URL: " + request.getRequestURL().toString());
        log.info("HTTP_METHOD: " + request.getMethod());
        log.info("IP: " + request.getRemoteAddr());
        log.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));

        //记录请求的参数，以及对应的值
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String arg = parameterNames.nextElement();
            log.info(arg + "=" + request.getParameter(arg));
        }
    }


    /**
     * 记录响应的状态码和信息
     *
     * @param res 响应的信息
     */
    @AfterReturning(returning = "res", pointcut = "pointcut()")
    public void doAfterReturn(Object res) {

        //获取响应信息
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();

        //记录响应的状态码和 响应信息
        int status = response.getStatus();
        log.info("STATUS: " + status);
        log.info("RESPONSE: " + res);
    }
}
