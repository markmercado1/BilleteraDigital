package com.example.mswallet.CiruitBreaker;

import com.example.mswallet.Dto.EventDTO;
import com.example.mswallet.Dto.EventUpdateSpentDTO;
import com.example.mswallet.Feign.EventFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class EventFeignFallback implements EventFeignClient {

    @Override
    public EventDTO getEventById(Long id) {
        log.warn("⚠️ ms-events no disponible — devolviendo evento dummy con id={}", id);
        return EventDTO.builder()
                .id(id)
                .name("Evento no disponible")
                .description("Sin conexión con ms-events")
                .budget(BigDecimal.ZERO)
                .spent(BigDecimal.ZERO)
                .build();
    }

    @Override
    public EventDTO updateEventSpent(Long id, EventUpdateSpentDTO updateDTO) {
        log.warn("⚠️ ms-events no disponible — no se pudo actualizar gasto del evento id={}", id);
        return EventDTO.builder()
                .id(id)
                .name("Evento no disponible")
                .description("Actualización simulada por fallo de conexión")
                .budget(BigDecimal.ZERO)
                .spent(updateDTO.getAmount())
                .build();
    }
}