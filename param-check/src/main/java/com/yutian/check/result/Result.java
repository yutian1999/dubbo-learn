/**
 * aljk.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yutian.check.result;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 *
 * @author wengyz
 * @version Result.java, v 0.1 2021-03-18 10:25 上午
 */
public class Result<T> implements Serializable {

    private boolean success;

    private String code;

    private String message;

    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}