/**
 * aljk.com
 * Copyright (C) 2013-2020All Rights Reserved.
 */
package com.yutian.facade;

import com.yutian.dto.RequestDTO;

import javax.validation.constraints.NotNull;

/**
 *
 * @author wengyz
 * @version ProviderService.java, v 0.1 2020-11-18 10:40 上午
 */
public interface ProviderService {

    String demo(String param);

    String checkParamDemo(@NotNull RequestDTO requestDTO);
}