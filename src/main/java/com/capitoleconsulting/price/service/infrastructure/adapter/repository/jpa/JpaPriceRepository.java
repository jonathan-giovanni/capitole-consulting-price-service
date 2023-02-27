package com.capitoleconsulting.price.service.infrastructure.adapter.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPriceRepository extends JpaRepository<JpaPriceEntity,JpaPriceEntityPk> {

}
