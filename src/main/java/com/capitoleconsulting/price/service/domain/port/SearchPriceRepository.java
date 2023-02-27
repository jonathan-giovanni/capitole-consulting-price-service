package com.capitoleconsulting.price.service.domain.port;

import com.capitoleconsulting.price.service.domain.model.Price;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public interface SearchPriceRepository {
    Stream<Price> findPriceInDateAndProductIdAndBrandId(LocalDateTime applicationDate, Long productId, Long brandId);
}
