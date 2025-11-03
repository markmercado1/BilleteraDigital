package com.example.mswallet.CiruitBreaker;

import com.example.mswallet.Dto.AuthUserDto;
import com.example.mswallet.Feign.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserFeignFallback implements UserFeignClient {

    @Override
    public AuthUserDto getUserById(Long id) {
        log.warn("⚠️ ms-auth no disponible — devolviendo usuario dummy con id={}", id);
        return AuthUserDto.builder()
                .userName("usuario_desconocido")
                .build();
    }
}
