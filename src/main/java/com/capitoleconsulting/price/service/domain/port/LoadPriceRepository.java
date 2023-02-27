package com.capitoleconsulting.price.service.domain.port;

import com.capitoleconsulting.price.service.domain.exception.LoadPriceException;
import com.capitoleconsulting.price.service.domain.model.Price;

import java.util.stream.Stream;

public interface LoadPriceRepository {
    Stream<Price> loadPrices() throws LoadPriceException;
}
