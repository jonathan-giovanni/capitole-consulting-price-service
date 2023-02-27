package com.capitoleconsulting.price.service.infrastructure.adapter.repository;

import com.capitoleconsulting.price.service.domain.model.Price;
import com.capitoleconsulting.price.service.domain.port.SearchPriceRepository;
import com.capitoleconsulting.price.service.infrastructure.adapter.repository.jpa.JpaPriceRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Component
public class DatabaseSearchPriceRepository implements SearchPriceRepository {

    private final JpaPriceRepository jpaPriceRepository;

    public DatabaseSearchPriceRepository(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Stream<Price> findPriceInDateAndProductIdAndBrandId(LocalDateTime applicationDate, Long productId, Long brandId) {
        return jpaPriceRepository
                .findAllByApplicationDateBetweenAndProductIdAndBrandId(applicationDate, productId, brandId)
                .map(jpaPriceEntity -> new Price(
                        jpaPriceEntity.getBrandId(),
                        jpaPriceEntity.getStartDate(),
                        jpaPriceEntity.getEndDate(),
                        jpaPriceEntity.getPriceList(),
                        jpaPriceEntity.getProductId(),
                        jpaPriceEntity.getPriority(),
                        jpaPriceEntity.getPrice(),
                        jpaPriceEntity.getCurrency(),
                        jpaPriceEntity.getUpdatedAt()
                ));
    }
}
