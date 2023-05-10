package com.zara.main.application.port.outbound.repository;

import com.zara.main.application.port.inbound.service.PricingService;
import com.zara.main.application.service.PriceMapper;
import com.zara.main.application.port.inbound.service.dto.PriceDto;
import com.zara.main.domain.exceptions.specificExceptions.BadRequestException;
import com.zara.main.domain.exceptions.specificExceptions.NoContentException;
import com.zara.main.infrastructure.persistence.entity.Price;
import com.zara.main.infrastructure.persistence.repository.PricingRepositoryJpa;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PricingRepository implements PricingService {

  private final  PricingRepositoryJpa pricingRepositoryJpa;
  private final  PriceMapper priceMapper;

    @Override
    public PriceDto addPrice(PriceDto price) {
        val priceF = priceMapper.priceFromPriceDto(price);
        pricingRepositoryJpa.saveAndFlush(priceF);
        return priceMapper.priceDtoFromPrice(priceF);
    }

    @Override
    public PriceDto getPriceByProductIdBrandIdStartDate(PriceDto price) throws BadRequestException, NoContentException {
        val priceDb = pricingRepositoryJpa.getByParams(price.getProductId(),price.getBrandId(),price.getStartDate());

        if (priceDb.isEmpty()) {
            throw new NoContentException("No matching prices found");
        }

        Price priceMod = priceDb.stream()
                .filter(priceF -> priceDb.size() == 1 || priceF.getPriority())
                .findFirst()
                .orElseThrow(() -> new BadRequestException("No matching price found"));

        return priceMapper.priceDtoFromPrice(priceMod);
    }

    @Override
    public String deletePrice(Long idBrand) throws NoContentException {
        if (pricingRepositoryJpa.existsById(idBrand)) {
            pricingRepositoryJpa.deleteById(idBrand);
            System.out.println("borrar`");
            return "borrado correctamente"; // Return the deletion message
        } else {
            System.out.println("no entra`");
            throw new NoContentException("No se ha encontrado el price que desea borrar");
        }
    }


    @Override
    public PriceDto updatePrice(PriceDto priceDto) throws NoContentException {
        pricingRepositoryJpa.findById(priceDto.getId()).orElseThrow(() -> new NoContentException("no se encuentra el price que quieres actualizar"));
        Price price = priceMapper.priceFromPriceDto(priceDto);
        return priceMapper.priceDtoFromPrice(pricingRepositoryJpa.saveAndFlush(price));
    }



}
