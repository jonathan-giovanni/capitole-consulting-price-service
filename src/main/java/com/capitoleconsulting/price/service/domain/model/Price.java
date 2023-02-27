package com.capitoleconsulting.price.service.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(Long brandId,
                    LocalDateTime startDate,
                    LocalDateTime endDate,
                    Long priceList,
                    Long productId,
                    Integer priority,
                    BigDecimal price,
                    String currency,
                    LocalDateTime updatedAt
                    ) {
}
