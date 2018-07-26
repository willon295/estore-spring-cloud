package com.briup.estore.common.advice;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * 全局 Controller 异常以及 ， 404 处理
 *
 * @author willon
 */
@ControllerAdvice
public class ErrorControllerAdvice {

    private Map<String, String> map = new HashMap<>();

    /**
     * 处理全局404
     *
     * @param e 异常信息
     * @return JSON格式的信息
     */
    @ResponseBody
    @ExceptionHandler(value = NotFoundException.class)
    public Map notFound(NotFoundException e) {
        map.put("code", "404");
        map.put("msg", "页面失踪了 ");
        return map;
    }


    /**
     * 全局其他异常处理
     *
     * @param e 异常
     * @return JSON 异常消息
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map error(Exception e) {
        map.put("code", "500");
        map.put("msg", "服务器内部错误");
        return map;
    }
}
