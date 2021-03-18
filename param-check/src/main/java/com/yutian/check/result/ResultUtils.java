/**
 * aljk.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yutian.check.result;

/**
 *
 * @author wengyz
 * @version ResultUtils.java, v 0.1 2021-03-18 10:28 上午
 */
public class ResultUtils {

    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "-10000";
    private static final String ERROR_MSG = "系统异常";

    public static <T> Result<T> success(){
        return success(null);
    }

    public static <T> Result<T> success(T t){
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setCode(SUCCESS_CODE);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> fail(String code,String msg){
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static <T> Result<T> fail(){
        return fail(ERROR_CODE,ERROR_MSG);
    }

}