package com.capitoleconsulting.price.service.infrastructure.adapter.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Repository
public interface JpaPriceRepository extends JpaRepository<JpaPriceEntity,JpaPriceEntityPk> {
    @Query("SELECT p FROM JpaPriceEntity p WHERE :applicationDate >= p.startDate AND :applicationDate <= p.endDate AND p.pk.productId = :productId AND p.pk.brandId = :brandId ")
    Stream<JpaPriceEntity> findAllByApplicationDateBetweenAndProductIdAndBrandId(LocalDateTime applicationDate,Long productId,Long brandId);
}
