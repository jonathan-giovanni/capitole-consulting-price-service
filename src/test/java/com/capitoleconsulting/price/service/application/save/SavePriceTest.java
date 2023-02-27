package com.capitoleconsulting.price.service.application.save;

import com.capitoleconsulting.price.service.PriceTestStub;
import com.capitoleconsulting.price.service.domain.exception.LoadPriceException;
import com.capitoleconsulting.price.service.domain.port.LoadPriceRepository;
import com.capitoleconsulting.price.service.domain.port.SavePriceRepository;
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

    private void mock_load_data_throws_error(){
        log.info("Mock load prices throws error");
        Mockito.when(loadPriceRepository.loadPrices()).thenThrow(LoadPriceException.class);
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

    @Test
    void loadAndSavePricesExpectedLoadPriceException() {
        mock_load_data_throws_error();
        mock_save_data_in_repository();

        Assertions.assertThrows(
                LoadPriceException.class,
                () -> savePrice.execute()
        );
    }



}
