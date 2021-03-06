/**
 * aljk.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yutian.check.filter;

import com.yutian.check.result.ResultUtils;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;

/**
 * 客户端做参数校验，减少不必要的交互
 * @author wengyz
 * @version DubboParamCheckFilter.java, v 0.1 2021-03-16 10:51 上午
 */
@Activate(group = "consumer",order = -1)
public class DubboConsumerParamCheckFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        boolean flag = false;
        Result result = new AsyncRpcResult(invocation);
        Class<?>[] parameterTypes = invocation.getParameterTypes();
        Object[] arguments = invocation.getArguments();
        try {
            Class<?> aClass = Class.forName(parameterTypes[0].getName());
            Field[] declaredFields = aClass.getDeclaredFields();
            StringBuilder sb = new StringBuilder();
            for (Field field : declaredFields) {
                NotNull annotation = field.getAnnotation(NotNull.class);
                if (annotation != null){
                    field.setAccessible(true);
                    Object o = field.get(arguments[0]);
                    if (o == null){
                        sb.append(field.getName()).append(",");
                        flag = true;
                    }
                }
            }
            if (flag){
                String str = sb.toString().substring(0,sb.toString().length() -1) + "不能为空";
                result.setValue(ResultUtils.fail("-10001",str).toString());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invoker.invoke(invocation);
    }
}