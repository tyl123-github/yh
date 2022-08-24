package com.yh.admin.service.feign;

import com.yh.admin.service.vo.UserVo;
import com.yh.common.core.utils.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @author yl_tao
 * @date 2022/5/26 11:26
 */
@FeignClient(value = "admin-service",contextId = "userClient")
public interface UserClient {

    @PostMapping("/user/findByUserName")
    UserVo findByUserName(@RequestParam("userName") String userName);
}
