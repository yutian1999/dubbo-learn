/**
 * aljk.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yutian.dto;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author wengyz
 * @version RequestDTO.java, v 0.1 2021-03-14 4:37 下午
 */
public class RequestDTO implements Serializable {

    private static final long serialVersionUID = 7158911668568000392L;

    @NotNull(message = "name 不能为空")
    private String name;

    @NotNull(message = "age 不能为空")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}