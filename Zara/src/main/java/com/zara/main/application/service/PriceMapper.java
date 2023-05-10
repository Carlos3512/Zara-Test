package com.zara.main.application.service;

import com.zara.main.application.port.inbound.service.dto.PriceDto;
import com.zara.main.application.port.outbound.repository.dto.PriceDtoOut;
import com.zara.main.infrastructure.persistence.entity.Price;
import org.mapstruct.*;
import org.springframework.stereotype.Service;


@Service
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(PriceMapperDecorator.class)
public interface PriceMapper {


    PriceDto priceDtoFromPrice(Price price);


    Price priceFromPriceDto(PriceDto priceDto);


    Price priceFromPriceDtoOut(PriceDtoOut priceDto);


    PriceDto priceDtoOutFromPrice(Price price);



}
