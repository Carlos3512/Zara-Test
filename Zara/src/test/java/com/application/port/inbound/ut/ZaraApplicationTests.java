package com.application.port.inbound.ut;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
		PricingServiceTest.class,

})
class ZaraApplicationTests {

}
