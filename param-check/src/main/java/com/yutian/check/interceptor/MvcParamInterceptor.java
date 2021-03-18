/**
 * aljk.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yutian.check.interceptor;
import com.alibaba.fastjson.JSON;
import com.yutian.check.exception.SystemException;
import com.yutian.check.result.ResultUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author wengyz
 * @version MvcParamInterceptor.java, v 0.1 2021-03-17 10:47 上午
 */
public class MvcParamInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("我是拦截器");
        RequestWrapper requestWrapper = new RequestWrapper(request);
        Map<String,Object> paramMap = JSON.parseObject(requestWrapper.getBody(),HashMap.class);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?>[] parameterTypes = handlerMethod.getMethod().getParameterTypes();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Class<?> parameterType : parameterTypes) {
            Class<?> aClass = Class.forName(parameterType.getName());
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                NotNull annotation = declaredField.getAnnotation(NotNull.class);
                if (annotation != null){
                    String contentType = request.getContentType();
                    if(contentType != null && contentType.contains("json")){
                        Object paramValue = paramMap.get(declaredField.getName());
                        if (paramValue == null){
                            response.getWriter().write(ResultUtils.fail("-10001",annotation.message()).toString());
                            response.setCharacterEncoding("utf-8");
                            response.setContentType("text/html;charset=utf-8");
                            response.getWriter().flush();
                            return false;
                        }
                    }else {
                        String[] paramValue = parameterMap.get(declaredField.getName());
                        if (paramValue == null || paramValue.length == 0 || paramValue[0] == null){
                            response.setCharacterEncoding("utf-8");
                            response.setContentType("text/html;charset=utf-8");
                            response.getWriter().write(ResultUtils.fail("-10001",annotation.message()).toString());
                            response.getWriter().flush();
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}