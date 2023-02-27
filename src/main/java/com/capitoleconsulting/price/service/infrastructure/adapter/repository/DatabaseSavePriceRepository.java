package com.capitoleconsulting.price.service.infrastructure.adapter.repository;

import com.capitoleconsulting.price.service.domain.model.Price;
import com.capitoleconsulting.price.service.domain.port.SavePriceRepository;

import java.util.stream.Stream;

/**
 * @author Jonathan Giovanni Hernandez
 * @company Finansoportes Consulting
 * @created 27/02/2023
 */
public class DatabaseSavePriceRepository implements SavePriceRepository {



    @Override
    public void saveAll(Stream<Price> prices) {

    }
}
