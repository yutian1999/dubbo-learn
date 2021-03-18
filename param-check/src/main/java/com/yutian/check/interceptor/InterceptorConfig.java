/**
 * aljk.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yutian.check.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author wengyz
 * @version InterceptorConfig.java, v 0.1 2021-03-17 10:53 上午
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MvcParamInterceptor()).addPathPatterns("/**").excludePathPatterns("/**/error");
    }
}