package com.zara.main.infrastructure.persistence.web;

import com.zara.main.application.port.inbound.service.PricingService;
import com.zara.main.application.port.inbound.service.dto.PriceDto;
import com.zara.main.domain.exceptions.specificExceptions.BadRequestException;
import com.zara.main.domain.exceptions.specificExceptions.NoContentException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PriceController {

      /*
       Crud generico para la tabla price.
     */

    private final PricingService pricingService;


    @PostMapping(path = "v1/price")
    public PriceDto addPrice(@RequestBody PriceDto price) throws BadRequestException {
        return pricingService.addPrice(price);
    }

    /*
    Endpoint para la prueba original
     */
    @PostMapping(path = "v1/price/zara")
    public PriceDto getPriceByParams(@RequestBody PriceDto price) throws BadRequestException, NoContentException {
        return pricingService.getPriceByProductIdBrandIdStartDate(price);
    }


    @DeleteMapping (path = "v1/price/{id}")
    public String deletePrice(long idRate) throws NoContentException {
        return pricingService.deletePrice(idRate);
    }

    @PutMapping(path = "v1/price")
    public PriceDto updateRate(PriceDto rates) throws BadRequestException, NoContentException {
        return pricingService.updatePrice(rates);
    }



}
