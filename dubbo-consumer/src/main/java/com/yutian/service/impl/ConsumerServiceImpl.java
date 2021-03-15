/**
 * aljk.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.service.impl;

import com.yutian.dto.RequestDTO;
import com.yutian.facade.ProviderService;
import com.yutian.service.ConsumerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;


/**
 *
 * @author wengyz
 * @version ConsumerServiceImpl.java, v 0.1 2020-11-18 11:28 上午
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Reference(id = "providerService",
            interfaceClass = com.yutian.facade.ProviderService.class,
            url = "dubbo://localhost:20881",
            version = "1.0.0",
            group = "dubbo-provider",
            validation = "true")
    private ProviderService providerService;


    @Override
    public String demo(String param) {
        return providerService.demo(param);
    }

    @Override
    public String checkParam(String param) {
        RequestDTO requestDTO = new RequestDTO();
        return providerService.checkParamDemo(requestDTO);
    }
}