package com.capitoleconsulting.price.service.infrastructure.adapter.repository;

import com.capitoleconsulting.price.service.domain.model.Price;
import com.capitoleconsulting.price.service.domain.port.SavePriceRepository;
import com.capitoleconsulting.price.service.infrastructure.adapter.repository.jpa.JpaPriceEntity;
import com.capitoleconsulting.price.service.infrastructure.adapter.repository.jpa.JpaPriceRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * @author Jonathan Giovanni Hernandez
 * @created 27/02/2023
 */
@Component
public class DatabaseSavePriceRepository implements SavePriceRepository {

    private final JpaPriceRepository jpaPriceRepository;

    public DatabaseSavePriceRepository(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    @Override
    public void saveAll(Stream<Price> prices) {
        jpaPriceRepository.saveAll(prices.map(p->new JpaPriceEntity(
                p.brandId(),
                p.startDate(),
                p.endDate(),
                p.priceList(),
                p.productId(),
                p.priority(),
                p.price(),
                p.currency(),
                p.updatedAt()
        )).toList());
    }
}
