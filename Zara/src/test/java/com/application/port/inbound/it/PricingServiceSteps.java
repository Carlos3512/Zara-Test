package com.application.port.inbound.it;

import com.zara.main.application.port.inbound.service.dto.PriceDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Cucumber.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceSteps {

    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<PriceDto> response;


    @Given("a price with start date of {string} for product ID {long} and brand ID {long}")
    public void createPrice(String startDate, long productId, long brandId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parsedStartDate = LocalDateTime.parse(startDate, formatter);

        PriceDto price = new PriceDto();
        price.setStartDate(parsedStartDate);
        price.setProductId(productId);
        price.setBrandId(brandId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PriceDto> request = new HttpEntity<>(price, headers);

        restTemplate = new TestRestTemplate();
        response = restTemplate.postForEntity("http://localhost:8080/v1/price/zara", request, PriceDto.class);
    }


    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        assertEquals(HttpStatus.valueOf(expectedStatusCode), response.getStatusCode());
    }

    @Then("the response body should not be null")
    public void verifyResponseBodyNotNull() {
        PriceDto priceDto = response.getBody();
        assertNotNull(priceDto);
    }


}

