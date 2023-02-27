package com.capitoleconsulting.price.service.infrastructure.startup;

import com.capitoleconsulting.price.service.application.save.SavePrice;
import com.capitoleconsulting.price.service.domain.exception.LoadPriceException;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jonathan Giovanni Hernandez
 * @created 27/02/2023
 */
@Configuration
public class LoadAndSaveDataOnStartup {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final SavePrice savePrice;

    public LoadAndSaveDataOnStartup(SavePrice savePrice) {
        this.savePrice = savePrice;
    }

    @PostConstruct
    void loadData(){
        log.info("Loading and save data on startup");
        try {
            savePrice.execute();
            log.info("Data loaded");
        }catch (LoadPriceException loadDataException){
            log.info("Could not load data");
        }catch (Exception ex){
            log.info("Error loading data: {}",ex.getMessage());
        }
    }


}
