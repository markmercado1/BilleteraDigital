package com.example.mswallet.Feign;

import com.example.mswallet.CiruitBreaker.EventFeignFallback;
import com.example.mswallet.Dto.EventDTO;

import com.example.mswallet.Dto.EventUpdateSpentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(
        name = "ms-events-service",
        path = "/events",
        fallbackFactory = EventFeignFallback.class
)
public interface EventFeignClient {

    @GetMapping("/{id}")
    EventDTO getEventById(@PathVariable("id") Long id);

    @PutMapping("/{id}/spent")
    EventDTO updateEventSpent(
            @PathVariable("id") Long id,
            @RequestBody EventUpdateSpentDTO updateDTO
    );
}
