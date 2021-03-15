/**
 * aljk.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.facade.impl;

import com.yutian.dto.RequestDTO;
import com.yutian.facade.ProviderService;
import org.apache.dubbo.config.annotation.Service;

/**
 *
 * @author wengyz
 * @version ProviderServiceImpl.java, v 0.1 2020-11-18 10:59 上午
 */
@Service(validation = "true")
public class ProviderServiceImpl implements ProviderService {


    @Override
    public String demo(String param) {
        System.out.println("hello everybody");
        return "everything is ok";
    }

    @Override
    public String checkParamDemo(RequestDTO requestDTO) {
        System.out.println(requestDTO);
        return "param check is success";
    }
}