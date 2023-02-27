package com.capitoleconsulting.price.service.application.search;

import com.capitoleconsulting.price.service.application.PriceTestStub;
import com.capitoleconsulting.price.service.domain.port.SearchPriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchPriceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private SearchPrice searchPrice;
    private SearchPriceRepository searchPriceRepository;

    @BeforeEach
    void setupTest(){
        log.info("Setup test");
        searchPriceRepository = Mockito.mock(SearchPriceRepository.class);
        searchPrice = new SearchPrice(searchPriceRepository);
    }

    @Test
    void searchPriceExpectedTheSamePrice() {

        log.info("Mock find price using -> applicationDate: {} , productId: {} , brandId: {}", PriceTestStub.applicationDate,PriceTestStub.existingProductId,PriceTestStub.existingBrandId);
        Mockito.when(searchPriceRepository.findPriceInDateAndProductIdAndBrandId(PriceTestStub.applicationDate,PriceTestStub.existingProductId,PriceTestStub.existingBrandId)).thenReturn(PriceTestStub.expectedPrices);

        var priceFound = searchPrice.execute(PriceTestStub.applicationDate,PriceTestStub.existingProductId,PriceTestStub.existingBrandId);
        log.info("Expected the same price");
        Assertions.assertEquals(PriceTestStub.expectedPrice,priceFound);
    }
}
