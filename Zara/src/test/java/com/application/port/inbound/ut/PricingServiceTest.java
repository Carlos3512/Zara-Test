package com.application.port.inbound.ut;
import com.zara.main.ZaraApplication;
import com.zara.main.application.port.inbound.service.PricingService;
import com.zara.main.application.port.inbound.service.dto.PriceDto;
import com.zara.main.application.port.outbound.repository.PricingRepository;
import com.zara.main.application.service.PriceMapper;
import com.zara.main.domain.exceptions.specificExceptions.BadRequestException;
import com.zara.main.domain.exceptions.specificExceptions.NoContentException;
import com.zara.main.infrastructure.persistence.entity.Price;
import com.zara.main.infrastructure.persistence.repository.PricingRepositoryJpa;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZaraApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceTest {

    @InjectMocks
    PricingRepository pricingRepository;

    @Mock
    PricingService pricingService;

    @Mock
    private PriceMapper priceMapper;

    @Mock
    private PricingRepositoryJpa pricingRepositoryJpa;

    @Test
    public void getPriceByProductIdBrandIdStartDate() throws BadRequestException, NoContentException {
        Price mockPrice = new Price();
        mockPrice.setId(1L);
        mockPrice.setBrandId(123L);
        mockPrice.setProductId(456L);
        mockPrice.setStartDate(LocalDateTime.now());
        mockPrice.setEndDate(LocalDateTime.now().plusDays(7));

        // Create a mock PriceDto object
        PriceDto mockPriceDto = new PriceDto();
        mockPriceDto.setId(1L);
        mockPriceDto.setProductId(456L);
        mockPriceDto.setBrandId(123L);
        mockPriceDto.setStartDate(mockPrice.getStartDate());

        // Create a mock PriceDto object for the test
        PriceDto testPriceDto = new PriceDto();
        testPriceDto.setId(1L);
        testPriceDto.setProductId(456L);
        testPriceDto.setBrandId(123L);
        testPriceDto.setStartDate(LocalDateTime.now());

        // Mock the behavior of pricingRepositoryJpa.getByParams
        Mockito.when(pricingRepositoryJpa.getByParams(Mockito.anyLong(), Mockito.anyLong(), Mockito.any(LocalDateTime.class)))
                .thenReturn(Collections.singletonList(mockPrice));


        // Mock the behavior of priceMapper.priceDtoFromPrice
        Mockito.when(priceMapper.priceDtoFromPrice(Mockito.any(Price.class)))
                .thenReturn(mockPriceDto);

        // Call the method under test
        final PriceDto res = pricingRepository.getPriceByProductIdBrandIdStartDate(testPriceDto);

        // Verify the expected behavior
        Assertions.assertEquals(mockPriceDto.getId(), res.getId());
        Assertions.assertEquals(mockPriceDto.getBrandId(), res.getBrandId());
        Assertions.assertEquals(mockPriceDto.getStartDate(), res.getStartDate());
        Mockito.verify(pricingRepositoryJpa, Mockito.times(1))
                .getByParams(Mockito.eq(testPriceDto.getProductId()), Mockito.eq(testPriceDto.getBrandId()), Mockito.eq(testPriceDto.getStartDate()));
        Mockito.verify(priceMapper, Mockito.times(1))
                .priceDtoFromPrice(Mockito.eq(mockPrice));
    }


}