/**
 * aljk.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.controller;

import com.yutian.service.ConsumerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author wengyz
 * @version DemoController.java, v 0.1 2020-11-18 11:32 上午
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private ConsumerService consumerService;

    @RequestMapping("/test")
    public String demo(){
        return consumerService.demo("yrt");
    }

    @RequestMapping("/check")
    public String checkParamDemo(){
        return consumerService.checkParam("yrt");
    }
}