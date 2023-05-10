package com.application.port.inbound.it;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.application.port.inbound.it")
@RunWith(Cucumber.class)
public class CucumberTestRunner {
}