package com.example.msgoals.Feign;


import com.example.msgoals.DTO.AuthUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-auth", path = "/api/auth")
public interface UserFeignClient {

    @GetMapping("/{id}")
    AuthUserDto getUserById(@PathVariable("id") Long id);
}