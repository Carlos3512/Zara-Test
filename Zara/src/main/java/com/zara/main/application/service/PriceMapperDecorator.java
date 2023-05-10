package com.zara.main.application.service;

import com.zara.main.application.port.inbound.service.dto.PriceDto;
import com.zara.main.application.port.outbound.repository.dto.PriceDtoOut;
import com.zara.main.infrastructure.persistence.entity.Price;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;


public class PriceMapperDecorator implements PriceMapper {

    @Autowired
    private PriceMapper delegate;

    @Override
    public PriceDto priceDtoFromPrice(Price price) {
        return delegate.priceDtoFromPrice(price);
    }

    @Override
    public Price priceFromPriceDto(PriceDto priceDto) {
        return delegate.priceFromPriceDto(priceDto);
    }

    @Override
    public Price priceFromPriceDtoOut(PriceDtoOut priceDto) {
        return delegate.priceFromPriceDtoOut(priceDto);
    }

    @Override
    public PriceDto priceDtoOutFromPrice(Price price) {
        return delegate.priceDtoOutFromPrice(price);
    }
}
