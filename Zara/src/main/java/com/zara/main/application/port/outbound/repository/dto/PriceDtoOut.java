package com.zara.main.application.port.outbound.repository.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceDtoOut {
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Long priceList;
    private Double price;
    private String curr;

}
