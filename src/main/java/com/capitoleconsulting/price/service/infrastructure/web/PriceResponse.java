package com.capitoleconsulting.price.service.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Jonathan Giovanni Hernandez
 * @company Finansoportes Consulting
 * @created 27/02/2023
 */
public record PriceResponse(
        @JsonProperty Long brandId,
        @JsonProperty LocalDateTime startDate,
        @JsonProperty LocalDateTime endDate,
        @JsonProperty Long priceList,
        @JsonProperty Long productId,
        @JsonProperty Integer priority,
        @JsonProperty BigDecimal price,
        @JsonProperty String currency,
        @JsonProperty LocalDateTime updatedAt
) {
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
