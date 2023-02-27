package com.capitoleconsulting.price.service.infrastructure.adapter.repository;

import com.capitoleconsulting.price.service.domain.model.Price;
import com.capitoleconsulting.price.service.domain.port.SearchPriceRepository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class DatabaseSearchPriceRepository implements SearchPriceRepository {
    @Override
    public Stream<Price> findPriceInDateAndProductIdAndBrandId(LocalDateTime applicationDate, Long productId, Long brandId) {
        return Stream.empty();
    }
}
