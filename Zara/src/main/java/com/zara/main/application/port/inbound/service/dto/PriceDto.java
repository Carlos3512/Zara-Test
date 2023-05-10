package com.zara.main.application.port.inbound.service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class PriceDto {
    private Long id;
    private Long brandId;
    private LocalDateTime startDate;
    private Long productId;
}
