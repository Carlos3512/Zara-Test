package com.zara.main.application.service;

import com.zara.main.application.port.inbound.service.dto.PriceDto;
import com.zara.main.application.port.outbound.repository.dto.PriceDtoOut;
import com.zara.main.infrastructure.persistence.entity.Price;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-10T12:40:11+0200",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class PriceMapperImpl_ implements PriceMapper {

    @Override
    public PriceDto priceDtoFromPrice(Price price) {
        if ( price == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        priceDto.setId( price.getId() );
        priceDto.setBrandId( price.getBrandId() );
        priceDto.setStartDate( price.getStartDate() );
        priceDto.setProductId( price.getProductId() );

        return priceDto;
    }

    @Override
    public Price priceFromPriceDto(PriceDto priceDto) {
        if ( priceDto == null ) {
            return null;
        }

        Price price = new Price();

        price.setId( priceDto.getId() );
        price.setBrandId( priceDto.getBrandId() );
        price.setStartDate( priceDto.getStartDate() );
        price.setProductId( priceDto.getProductId() );

        return price;
    }

    @Override
    public Price priceFromPriceDtoOut(PriceDtoOut priceDto) {
        if ( priceDto == null ) {
            return null;
        }

        Price price = new Price();

        price.setBrandId( priceDto.getBrandId() );
        price.setStartDate( priceDto.getStartDate() );
        price.setEndDate( priceDto.getEndDate() );
        price.setProductId( priceDto.getProductId() );
        price.setPriceList( priceDto.getPriceList() );
        price.setPrice( priceDto.getPrice() );
        price.setCurr( priceDto.getCurr() );

        return price;
    }

    @Override
    public PriceDto priceDtoOutFromPrice(Price price) {
        if ( price == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        priceDto.setId( price.getId() );
        priceDto.setBrandId( price.getBrandId() );
        priceDto.setStartDate( price.getStartDate() );
        priceDto.setProductId( price.getProductId() );

        return priceDto;
    }
}
