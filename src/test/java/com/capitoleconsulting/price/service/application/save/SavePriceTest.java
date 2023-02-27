package com.capitoleconsulting.price.service.application.save;

import com.capitoleconsulting.price.service.application.PriceTestStub;
import com.capitoleconsulting.price.service.application.search.SearchPrice;
import com.capitoleconsulting.price.service.domain.port.LoadPriceRepository;
import com.capitoleconsulting.price.service.domain.port.SavePriceRepository;
import com.capitoleconsulting.price.service.domain.port.SearchPriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SavePriceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private LoadPriceRepository loadPriceRepository;
    private SavePriceRepository savePriceRepository;
    private SavePrice savePrice;

    private void mock_load_data(){
        log.info("Mock load prices");
        Mockito.when(loadPriceRepository.loadPrices()).thenReturn(PriceTestStub.expectedPrices);
    }

    private void mock_save_data_in_repository(){
        log.info("Mock do nothing on save prices");
        Mockito.doNothing().when(savePriceRepository).saveAll(PriceTestStub.expectedPrices);
    }

    @BeforeEach
    void setupTest(){
        log.info("Setup test");
        loadPriceRepository = Mockito.mock(LoadPriceRepository.class);
        savePriceRepository = Mockito.mock(SavePriceRepository.class);
        savePrice = new SavePrice(loadPriceRepository,savePriceRepository);
    }

    @Test
    void loadAndSavePricesWithoutErrors() {
        mock_load_data();
        mock_save_data_in_repository();
        savePrice.execute();
    }

}
