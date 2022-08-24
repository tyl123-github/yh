/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yh.common.core.utils;

import com.yh.common.core.constant.CommonConstants;
import lombok.*;

import java.io.Serializable;

/**
 * 功能描述: 响应信息主体
 *
 * @author yl_tao
 * @date 2022/4/29 19:30
 */
@Data
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private T data;

    public static <T> ApiResult<T> success() {
        return restResult(null, CommonConstants.SUCCESS, null);
    }

    public static <T> ApiResult<T> success(T data) {
        return restResult(data, CommonConstants.SUCCESS, null);
    }

    public static <T> ApiResult<T> success(T data, String msg) {
        return restResult(data, CommonConstants.SUCCESS, msg);
    }

    public static <T> ApiResult<T> failed() {
        return restResult(null, CommonConstants.FAIL, null);
    }

    public static <T> ApiResult<T> failed(String msg) {
        return restResult(null, CommonConstants.FAIL, msg);
    }

    public static <T> ApiResult<T> failed(T data) {
        return restResult(data, CommonConstants.FAIL, null);
    }

    public static <T> ApiResult<T> failed(T data, String msg) {
        return restResult(data, CommonConstants.FAIL, msg);
    }

    private static <T> ApiResult<T> restResult(T data, String code, String msg) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

}
