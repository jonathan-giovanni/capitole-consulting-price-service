package com.capitoleconsulting.price.service.application.save;

import com.capitoleconsulting.price.service.domain.port.LoadPriceRepository;
import com.capitoleconsulting.price.service.domain.port.SavePriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SavePrice {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final LoadPriceRepository loadPriceRepository;
    private final SavePriceRepository savePriceRepository;

    public SavePrice(LoadPriceRepository loadPriceRepository, SavePriceRepository savePriceRepository) {
        this.loadPriceRepository = loadPriceRepository;
        this.savePriceRepository = savePriceRepository;
    }

    public void execute(){
        savePriceRepository.saveAll(loadPriceRepository.loadPrices());
    }


}
