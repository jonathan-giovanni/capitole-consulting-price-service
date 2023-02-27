package com.capitoleconsulting.price.service.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Jonathan Giovanni Hernandez
 * @company Finansoportes Consulting
 * @created 27/02/2023
 */
public class PriceResponse {
    @JsonProperty
    private final Long brandId;
    @JsonProperty
    private final LocalDateTime startDate;
    @JsonProperty
    private final LocalDateTime endDate;
    @JsonProperty
    private final Long priceList;
    @JsonProperty
    private final Long productId;
    @JsonProperty
    private final Integer priority;
    @JsonProperty
    private final BigDecimal price;
    @JsonProperty
    private final String currency;
    @JsonProperty
    private final LocalDateTime updatedAt;

    public PriceResponse(Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId, Integer priority, BigDecimal price, String currency, LocalDateTime updatedAt) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
        this.updatedAt = updatedAt;
    }
}
