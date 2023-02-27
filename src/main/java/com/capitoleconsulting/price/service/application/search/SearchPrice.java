package com.capitoleconsulting.price.service.application.search;

import com.capitoleconsulting.price.service.domain.exception.PriceNotFoundException;
import com.capitoleconsulting.price.service.domain.model.Price;
import com.capitoleconsulting.price.service.domain.port.SearchPriceRepository;

import java.time.LocalDateTime;
import java.util.Comparator;

public class SearchPrice {
    private final SearchPriceRepository searchPriceRepository;

    public SearchPrice(SearchPriceRepository searchPriceRepository) {
        this.searchPriceRepository = searchPriceRepository;
    }

    public Price execute(LocalDateTime applicationDate,Long productId,Long brandId){
        return searchPriceRepository.findPriceInDateAndProductIdAndBrandId(applicationDate, productId, brandId).max(Comparator.comparing(Price::priority)).orElseThrow(PriceNotFoundException::new);
    }
}
