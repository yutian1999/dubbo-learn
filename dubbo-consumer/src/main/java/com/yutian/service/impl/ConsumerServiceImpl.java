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

    @Reference
    private ProviderService providerService;


    @Override
    public String demo(String param) {
        return providerService.demo(param);
    }

    @Override
    public String checkParam(String param) {
        RequestDTO requestDTO = new RequestDTO();
//        requestDTO.setName("wyz");
//        requestDTO.setAge(18);
        return providerService.checkParamDemo(requestDTO);
    }
}