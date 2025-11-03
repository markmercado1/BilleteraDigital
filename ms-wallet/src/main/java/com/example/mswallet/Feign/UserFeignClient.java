package com.example.mswallet.Feign;

import com.example.mswallet.CiruitBreaker.UserFeignFallback;
import com.example.mswallet.Dto.AuthUserDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ms-auth-service",
        path = "/auth",
        fallbackFactory = UserFeignFallback.class
)
public interface UserFeignClient {

    @GetMapping("/{id}")
    AuthUserDto getUserById(@PathVariable Long id);
}
