package com.example.mswallet.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal budget;
    private BigDecimal spent;
    private LocalDate startDate;
    private LocalDate endDate;
}