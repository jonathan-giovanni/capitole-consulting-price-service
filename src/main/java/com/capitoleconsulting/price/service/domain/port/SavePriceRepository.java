package com.capitoleconsulting.price.service.domain.port;

import com.capitoleconsulting.price.service.domain.model.Price;

import java.util.stream.Stream;

public interface SavePriceRepository {
    void saveAll(Stream<Price> prices);
}
